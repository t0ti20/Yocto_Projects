# License information
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
# Source URI
SRC_URI = "git://github.com/t0ti20/Device_Driver;protocol=https;branch=master"
# Package version and source revision
PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"
# Source directory
S = "${WORKDIR}/git"
# Module name according to make file
MODULE_NAME= "LED"
# Inherit module class
inherit module
# Pass MODULE_NAME using EXTRA_OEMAKE
EXTRA_OEMAKE += "MODULE_NAME=${MODULE_NAME}"
# Provide kernel-module-control-button
RPROVIDES:${PN} += "kernel-module-control-button"