#!/bin/sh

usage() {
    printf "\nUsage: MACHINE=<machine> DISTRO=<distro> source demo-custom-setup.sh <build-dir>\n"
    printf "Optional parameters: [-h]\n"
}

if [ "$1" = "-h" ] || [ "$1" = "--help" ]; then
    usage
    return 0
fi

if [ "$#" -ne 1 ]; then
    usage
    return 1
fi

BUILD_DIR="$1"
BSPDIR="$(pwd)"

MACHINE=${MACHINE} DISTRO=${DISTRO} . poky/oe-init-build-env ${BUILD_DIR}

#add extra layers :
# meta-openembedded/meta-oe 
# meta-openembedded/meta-python 
# meta-openembedded/meta-multimedia
# meta-raspberrypi 
# meta-custom-demo-application

for layer in meta-openembedded/meta-oe meta-openembedded/meta-python meta-openembedded/meta-multimedia meta-raspberrypi meta-custom-demo-application; do
  L="${BSPDIR}/${layer}"
  if ! bitbake-layers show-layers | awk 'NR>1{print $2}' | grep -qx "$L"; then
    bitbake-layers add-layer "$L"
    printf '✅ Added layer: %s\n' "$L"
  else
    printf 'ℹ️  Layer already present: %s\n' "$L"
  fi
done

confdir="conf/local.conf"
sed -i "s/^DISTRO.*$/DISTRO = \"$DISTRO\"/" "$confdir" 
sed -i "s/^MACHINE.*$/MACHINE = \"$MACHINE\"/" "$confdir" 