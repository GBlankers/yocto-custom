SUMMARY = "Custom image based on core-image-minimal with added root user password."

# Install the minimal boot packages + iptabels and python3 (included in the oe-core layer)
# As well as extra packages defined in build local.conf file with the CORE_IMAGE_EXTRA_INSTALL 
# variable
IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL} iptables python3 python3-pip"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image
inherit extrausers

# Set root size to 200MiB
IMAGE_OVERHEAD_FACTOR ?= "1.0"
IMAGE_ROOTFS_SIZE ?= "102400"

# Change root password
EXTRA_USERS_PARAMS = " \
  usermod -p V89CLCUgGSQMw root; \
  useradd sshuser; \
  usermod -p VEQjKMI1oSl2w sshuser; \
  "


create_status_dir() {
        touch ${IMAGE_ROOTFS}/tmp/status
        chmod 777 ${IMAGE_ROOTFS}/tmp/status
}

ROOTFS_POSTPROCESS_COMMAND += "create_status_dir; "
