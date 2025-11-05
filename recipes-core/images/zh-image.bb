require recipes-core/images/core-image-base.bb

# Bundles like SSH/debug etc.
EXTRA_IMAGE_FEATURES += " debug-tweaks ssh-server-openssh"

# Packets like nano etc.
IMAGE_INSTALL:append = " nano python3-flask"
