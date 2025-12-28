FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://config.txt"

do_deploy:append() {
    install -m 0644 ${WORKDIR}/config.txt ${DEPLOYDIR}/bootfiles/config.txt
}
