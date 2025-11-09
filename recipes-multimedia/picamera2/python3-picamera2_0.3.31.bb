SUMMARY = "Picamera2 - Python API for libcamera (Raspberry Pi)"
HOMEPAGE = "https://github.com/raspberrypi/picamera2"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6541a38108b5accb25bd55a14e76086d"

SRC_URI = "git://github.com/raspberrypi/picamera2.git;branch=main;protocol=https"
SRCREV = "63f3be10e317c4b4b0a93e357d7db18fe098e9d4"
PV = "0.3.31+git${SRCPV}"

S = "${WORKDIR}/git"

# setuptools (setup.py), not python_pep517
inherit setuptools3

# Zależności runtime – dopasuj nazwę pakietu z libcamera bbappend!
RDEPENDS:${PN} += "\
    python3-core \
    python3-numpy \
    python3-pillow \
    libcamera \
    libcamera-python \
"

# Tell packaging where the module files are located
FILES:${PN} += "\
    ${PYTHON_SITEPACKAGES_DIR}/picamera2 \
    ${PYTHON_SITEPACKAGES_DIR}/picamera2-*.dist-info \
"

# optional, remove unneeded files to slim the package
do_install:append() {
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/{apps,examples,tests,tools,build,.git,.github,CHANGELOG.md,README.md,requirements*} || true
}
