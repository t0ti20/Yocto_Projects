#Change Source Files Location
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
#Select My Custom Configure Uboot Commands
SRC_URI = "http://w1.fi/releases/wpa_supplicant-${PV}.tar.gz \
           file://defconfig \
           file://wpa-supplicant.sh \
           file://wpa_supplicant.conf \
           file://wpa_supplicant.conf-sane \
           file://99_wpa_supplicant \
           "