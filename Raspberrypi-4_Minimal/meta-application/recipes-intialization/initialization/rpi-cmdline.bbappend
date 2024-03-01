# Redefine variables from the original recipe
CMDLINE_DWC_OTG = "dwc_otg.lpm_enable=0"
CMDLINE_SERIAL = "${@oe.utils.conditional("ENABLE_UART", "1", "console=serial0,115200 console=tty1 console=ttyS0", "console=tty1 console=ttyS0", d)}"
CMDLINE_ROOT_FSTYPE = "rootfstype=ext4"
CMDLINE_ROOTFS = "root=/dev/sda2 ${CMDLINE_ROOT_FSTYPE} rootwait"

