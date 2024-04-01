# License information
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
# Source URI
SRC_URI = "git://github.com/t0ti20/CPP_Application;protocol=https;branch=master"
# Package version and source revision
PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"
# Define dependencies
DEPENDS += "control-led control-button"
# Source directory
S = "${WORKDIR}/git"
# Application Folder Name You Want To Compile
APPLICATION_NAME= "Device_Driver_Test"
# Inherit module class
inherit cmake
# Pass APPLICATION_NAME using EXTRA_OEMAKE
EXTRA_OECMAKE += "-DApplication_Name=${APPLICATION_NAME}"