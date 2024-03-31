#!/bin/sh
### BEGIN INIT INFO
# Provides:          wifi_setup
# Required-Start:    $remote_fs $syslog
# Required-Stop:     $remote_fs $syslog
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: Initialize WiFi setup
# Description:       Initialize WiFi setup at boot time
### END INIT INFO

while true; do
    echo "Starting WiFi setup script"
    
    # Enable WiFi support using connmanctl
    connmanctl enable wifi
    
    # Bring up the wlan0 interface
    ifconfig wlan0 up
    
    # Check if wlan0 interface is up
    if ifconfig wlan0 up; then
        # Initialize a flag for client detection
        ClientDetected=0
        
        # Loop until a client is detected
        while [ $ClientDetected -ne 1 ]; do
            # Initialize a counter
            Count=0
            
            # Remove any existing wpa_supplicant runtime directory
            rm -rf /var/run/wpa_supplicant/wlan0
            
            # Wait for 5 seconds
            sleep 5
            
            # Start wpa_supplicant for wlan0 interface
            wpa_supplicant -B -i wlan0 -c /etc/wpa_supplicant.conf
            
            # Check if wpa_supplicant started successfully
            if [ $? -eq 0 ]; then
                # Loop for 10 seconds to check if wlan0 is connected
                while [ $Count -le 10 ]; do
                    # Check if wlan0 is connected
                    iw wlan0 link | grep "Connected"
                    
                    # If wlan0 is connected, set ClientDetected flag and break the loop
                    if [ $? -eq 0 ]; then
                        ClientDetected=1
                        break
                    else
                        echo "Client not detected"
                    fi
                    
                    # Wait for 1 second
                    sleep 1
                    
                    # Increment the counter
                    Count=$((Count + 1))
                done
                
                # If client is detected, assign static IP address
                if [ $ClientDetected -eq 1 ]; then
                    echo "Client detected"
                    ifconfig wlan0 192.168.1.10 netmask 255.255.255.0 up
                    route add default gw 192.168.1.1
                    echo "nameserver 8.8.8.8" > /etc/resolv.conf
                    exit 0 # Success exit code
                fi
            fi
        done
    else
        echo "WLAN not available"
        sleep 10 # Sleep before retrying
    fi
done

exit 1

