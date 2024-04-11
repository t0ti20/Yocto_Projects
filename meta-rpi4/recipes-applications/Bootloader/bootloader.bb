# License information
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
# Source URI
SRC_URI = "git://github.com/t0ti20/CPP_Application;protocol=https;branch=master"
SRC_URI:append = " file://Auto-Flash.service "
# Package version and source revision
PV = "1.0+git${SRCPV}"
# Automatically get the latest revision from Git
SRCREV = "${AUTOREV}"
# Define dependencies
DEPENDS += "enable-wifi boost"
# Source directory
S = "${WORKDIR}/git"
# Application Folder Name You Want To Compile
APPLICATION_NAME= "Bootloader"
# Inherit module class
inherit cmake systemd
# Enable the systemd service by default
SYSTEMD_AUTO_ENABLE = "enable"
# Define the systemd service associated with the package for SYSTEMD_DEFAULT_TARGET
SYSTEMD_SERVICE:${PN} = "Auto-Flash.service"
# Pass APPLICATION_NAME using EXTRA_OEMAKE
EXTRA_OECMAKE += "-DApplication_Name=${APPLICATION_NAME}"
do_install:append(){
    # Create the systemd unit directory in the root filesystem
    install -d ${D}/${systemd_unitdir}/system/
    # Install the systemd service file
    install -m 0644 ${WORKDIR}/Auto-Flash.service ${D}/${systemd_unitdir}/system/
}
# Include the Test_CPP executable in the package files
FILES:${PN} += "${bindir}/${APPLICATION_NAME}"
# Include the systemd service file in the package files
FILES:${PN} += "${systemd_unitdir}/system/Auto-Flash.service"