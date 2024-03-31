# Redefine variables from the original recipe
#CMDLINE_SERIAL = "${@oe.utils.conditional("ENABLE_UART", "1", "console=tty1,115200", "", d)}"
CMDLINE_SERIAL = "${@oe.utils.conditional("ENABLE_UART", "1", "", "", d)}"
CMDLINE_ROOT_FSTYPE = "ip=192.168.0.10 nfsroot=192.168.0.100:/Network_File_System/RFS,v4,tcp"
CMDLINE_ROOTFS = "root=/dev/nfs ${CMDLINE_ROOT_FSTYPE} rootwait"