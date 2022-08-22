FILESEXTRAPATHS:prepend := "${THISDIR}/files:${THISDIR}/imx8mm-lpddr4-evk:${THISDIR}:"

# Patch device tree to include the m4 coprocessor
SRC_URI += "file://0001-enable-m4-devicetree.patch"
#            file://0002-enable-m4-root-dts.patch"

# Apply default configuration
KERNEL_DEFCONFIG:imx8mm-lpddr4-evk = "defconfig"
