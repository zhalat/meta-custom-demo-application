require recipes-core/images/core-image-base.bb

# Bundles like SSH/debug etc.
EXTRA_IMAGE_FEATURES += " debug-tweaks ssh-server-openssh"
# Bundles like development packages for example libcamera-dev
EXTRA_IMAGE_FEATURES += " dev-pkgs "

# Packets like nano etc.
IMAGE_INSTALL:append = " \
nano \
tree \
python3-flask \
python3-picamera2 \
python3-core \
python3-modules \
python3-pip \
python3-fcntl \
libcamera \
libcamera-dev \
libcamera-python \
libcamera-apps \
packagegroup-core-buildessential \
"
