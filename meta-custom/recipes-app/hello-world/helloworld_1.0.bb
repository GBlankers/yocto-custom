DESCRIPTION = "A test application to print hello world"
PRIORITY = "optional"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# The files directory is automaically searched so no need to add it to extrafilespath
SRC_URI = "file://hello-world.c"

S = "${WORKDIR}"

do_compile() {
${CC} ${CFLAGS} ${LDFLAGS} hello-world.c -o helloworld
}

do_install() {
# install -d : create all specified directories or treat all arguments as directories
# ${D}${bindir} : Destination directory/location of the 'bin' directory
install -d ${D}${bindir}
# Copy the helloworld file to the created directory and change the permissions
install -m 0755 helloworld ${D}${bindir}
}
