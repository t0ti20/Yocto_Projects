LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
#Set source files locations
SRC_URI = "file://Enable_Wifi.service \
           file://Enable_Wifi.sh \
          "
# Inherit CMake and systemd classes for handling build and installation
inherit systemd
# Enable the systemd service by default
SYSTEMD_AUTO_ENABLE = "enable"
# Define the systemd service associated with the package for SYSTEMD_DEFAULT_TARGET
SYSTEMD_SERVICE:${PN} = "Enable_Wifi.service"
# Over Write do_install function for installing files into the root filesystem
do_install(){
    # Create the binary directory in the root filesystem
    install -d ${D}${bindir}
    # Create the systemd unit directory in the root filesystem
    install -d ${D}/${systemd_unitdir}/system/
    # Install the Test_CPP executable to the binary directory
    install -m 0755 ${WORKDIR}/Enable_Wifi.sh ${D}${bindir}/
    # Install the systemd service file
    install -m 0644 ${WORKDIR}/Enable_Wifi.service ${D}/${systemd_unitdir}/system/
}
# Include the Test_CPP executable in the package files
FILES:${PN} += "${bindir}/Enable_Wifi.sh"
# Include the systemd service file in the package files
FILES:${PN} += "${systemd_unitdir}/system/Enable_Wifi.service"