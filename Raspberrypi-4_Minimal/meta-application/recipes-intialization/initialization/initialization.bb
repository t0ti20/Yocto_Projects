DESCRIPTION = "Script to setup wifi network"
SECTION = "network"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://wifi_setup \
          "
S = "${WORKDIR}"

DEPENDS += "wpa-supplicant"

do_install() {
    install -d ${D}${bindir}
    install -m 0777 ${WORKDIR}/wifi_setup ${D}${bindir}/wifi_setup
    install -d ${D}${sysconfdir}/rc5.d
    install -m 0777 ${WORKDIR}/wifi_setup ${D}${sysconfdir}/rc5.d/S34wifi_setup
}

FILES_${PN} += "${bindir}/wifi_setup \
                ${sysconfdir}/rc5.d/S34wifi-setup \
               "
