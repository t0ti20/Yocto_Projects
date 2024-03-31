# Recipe for user and group management using features from useradd.bbclass
# This recipe serves as an example for adding a user and group with specific parameters
# The resulting user and group will be used for package installation and ownership purposes
SUMMARY = "Recipe for using inherit useradd"
DESCRIPTION = "This recipe serves as an example for using features from useradd.bbclass"
# License for this recipe is MIT, allowing for unrestricted use, modification, and distribution
LICENSE = "MIT"
# Set the source directory to ${WORKDIR}, where source files are manipulated during the build process
S = "${WORKDIR}"
# Hashed password for the user 't0ti20'
PASSWD = "\$5\$dzDR54TmnRgw7RE1\$DciM2Gb1QjVz15sW5BcPkKQKNRRNxN/dqhyvL9IKrR4"
# Inherit useradd functionality from useradd.bbclass
inherit useradd 
# Specify which package triggers user creation
USERADD_PACKAGES = "${PN}"
# Define parameters for useradd command to create 't0ti20' user with specific attributes
USERADD_PARAM:${PN} = "-u 1200 -g t0ti20 -d /home/t0ti20 -r -s /bin/sh -p '${PASSWD}' t0ti20"
# Define parameters for groupadd command to create 't0ti20' group with specific GID
GROUPADD_PARAM:${PN} = "-g 1200 t0ti20"
do_install(){
    # Create home directory for 't0ti20' user
	install -d -m 755 ${D}/home/t0ti20
    # Set ownership of home directory to 't0ti20'
	chown -R t0ti20:t0ti20 ${D}/home/t0ti20
}
# Specify files to be included in the final package, including the home directory for 't0ti20' user
FILES:${PN} = "/home/t0ti20"
