SUMMARY = "Custom sshd_config for zh-distro"
LICENSE = "CLOSED"

python do_display_before_fetching() {
    bb.plain("*************************************************************");
    bb.plain("* To be able to connect to via ssh you must                 *");
    bb.plain("* provide your id_rsa.pub key to ~/.ssh/authorized_keys     *");
    bb.plain("*************************************************************");
}

SRC_URI = "file://sshd_config"
S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/ssh
    install -m 0600 ${WORKDIR}/sshd_config ${D}${sysconfdir}/ssh/sshd_config
}

FILES:${PN} = "${sysconfdir}/ssh/sshd_config"
RDEPENDS:${PN} = "openssh-sshd"