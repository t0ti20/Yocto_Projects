SUMMARY = "VsomeIP Hello World Example"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "vsomeip"

SRC_URI = "file://CMakeLists.txt \
           file://hello_world_client.hpp \
           file://hello_world_client_main.cpp \
           file://hello_world_service.hpp \
           file://hello_world_service_main.cpp \
           file://helloworld-local.json"

S = "${WORKDIR}"

inherit cmake
 
#do_install() {
#    	install -d ${D}${bindir}
#	install -m 0755 Application ${D}${bindir}
#}
