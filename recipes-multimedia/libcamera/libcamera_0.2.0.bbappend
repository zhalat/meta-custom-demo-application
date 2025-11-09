# maps to libcamera version 0.2.0
PACKAGECONFIG[pycamera] = "-Dpycamera=enabled,-Dpycamera=disabled,python3-pybind11-native"

PACKAGECONFIG:append:pn-libcamera = " pycamera"

PACKAGES += "${PN}-python"
FILES:${PN}-python = "${PYTHON_SITEPACKAGES_DIR}/*.so ${PYTHON_SITEPACKAGES_DIR}/libcamera*"

RPROVIDES:${PN}-python += "libcamera-python"
