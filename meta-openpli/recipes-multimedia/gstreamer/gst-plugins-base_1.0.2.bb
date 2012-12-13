require gst-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3 \
                    file://common/coverage/coverage-report.pl;beginline=2;endline=17;md5=622921ffad8cb18ab906c56052788a3f \
                    file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605 \
                    "

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'x11', 'virtual/libx11 libxv', '', d)}"
DEPENDS += "alsa-lib freetype liboil libogg libvorbis libtheora avahi util-linux tremor"

SRC_URI[md5sum] = "57cff96bfbb5e6f06c4226b141e1f990"
SRC_URI[sha256sum] = "7ce2c4462ff89f62a82b4503a3788ce2e5077f886e535796fecc223397acf78d"

PR = "r0"

inherit gettext

EXTRA_OECONF += "--disable-freetypetest --disable-pango --disable-gnome_vfs --disable-orc"

do_configure_prepend() {
	# This m4 file contains nastiness which conflicts with libtool 2.2.2
	rm -f ${S}/m4/lib-link.m4
}

FILES_${PN} += "${datadir}/${BPN}"
