# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://github.com/t0ti20/CPP_Application;protocol=https;branch=master"
SRC_URI:append = " file://Test_CPP.service "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"


S = "${WORKDIR}/git"

inherit cmake systemd

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "Test_CPP.service"
#SYSTEMD_DEFAULT_TARGET

do_install() {
    install -d ${D}${bindir}
    install -d ${D}/${systemd_unitdir}/system/
    install -m 0755 ${B}/Test_CPP ${D}${bindir}/
    install -m 0644 ${WORKDIR}/Test_CPP.service ${D}/${systemd_unitdir}/system/
}

FILES:${PN} += "${bindir}/Test_CPP"
FILES:${PN} += "${systemd_unitdir}/system/Test_CPP.service"