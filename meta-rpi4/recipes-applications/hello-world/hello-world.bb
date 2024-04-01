# License information
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
# Set source files locations
SRC_URI = "git://github.com/t0ti20/CPP_Application;protocol=https;branch=master"
SRC_URI:append = " file://Test_CPP.service "
# Set the package version
PV = "1.0+git${SRCPV}"
# Automatically get the latest revision from Git
SRCREV = "${AUTOREV}"
# Set the source directory
S = "${WORKDIR}/git"
# Inherit CMake and systemd classes for handling build and installation
inherit cmake systemd
# Extra options to pass to cmake during the build
EXTRA_OECMAKE = ""
# Enable the systemd service by default
SYSTEMD_AUTO_ENABLE = "enable"
# Define the systemd service associated with the package for SYSTEMD_DEFAULT_TARGET
SYSTEMD_SERVICE:${PN} = "Test_CPP.service"
# Over Write do_install function for installing files into the root filesystem
do_install(){
    # Create the binary directory in the root filesystem
    install -d ${D}${bindir}
    # Create the systemd unit directory in the root filesystem
    install -d ${D}/${systemd_unitdir}/system/
    # Install the Test_CPP executable to the binary directory
    install -m 0755 ${B}/Test_CPP ${D}${bindir}/
    # Install the systemd service file
    install -m 0644 ${WORKDIR}/Test_CPP.service ${D}/${systemd_unitdir}/system/
}
# Include the Test_CPP executable in the package files
FILES:${PN} += "${bindir}/Test_CPP"
# Include the systemd service file in the package files
FILES:${PN} += "${systemd_unitdir}/system/Test_CPP.service"