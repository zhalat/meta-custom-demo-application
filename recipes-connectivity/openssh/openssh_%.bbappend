FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append = " file://sshd_config"

do_install:append() {
    install -m 600 ${WORKDIR}/sshd_config ${D}${sysconfdir}/ssh/sshd_config
}
