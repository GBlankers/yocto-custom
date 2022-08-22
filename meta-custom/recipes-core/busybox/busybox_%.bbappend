# Search for files in this path, PN = the name of the recipe (in this case busybox)
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
# Use this file, path is relative to FILESEXTRAPATHS
SRC_URI += "file://crontab.cfg \
            file://ntpd.cfg"

