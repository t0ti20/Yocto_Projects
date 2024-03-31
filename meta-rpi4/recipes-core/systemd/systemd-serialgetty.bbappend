SUMMARY = "Removing Starting Getty Serial"
do_install:append(){
    rm -f ${D}${sysconfdir}/systemd/system/getty.target.wants/serial-getty@$ttydev.service
    rm -f ${D}${sysconfdir}/systemd/system/getty.target.wants/serial-getty$baudrate@$ttydev.service
}