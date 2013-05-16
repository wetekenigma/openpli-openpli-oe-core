require gst-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+ & LGPLv2.1+ "
LIC_FILES_CHKSUM = "file://COPYING;md5=73a5855a8119deb017f5f13cf327095d \
                    file://gst/tta/filters.h;beginline=12;endline=29;md5=8a08270656f2f8ad7bb3655b83138e5a \
                    file://COPYING.LIB;md5=21682e4e8fea52413fd26c60acb907e5 \
                    file://gst/tta/crc32.h;beginline=12;endline=29;md5=71a904d99ce7ae0c1cf129891b98145c"

DEPENDS += "gst-plugins-base libmusicbrainz tremor librsvg curl"

PR = "r0"

inherit gettext

EXTRA_OECONF += "--disable-examples --disable-experimental --disable-sdl --disable-cdaudio --disable-directfb \
                 --with-plugins=musicbrainz,wavpack,ivorbis,mpegvideoparse --disable-vdpau --disable-apexsink \
                 --disable-orc"

ARM_INSTRUCTION_SET = "arm"

do_configure_prepend() {
	# This m4 file contains nastiness which conflicts with libtool 2.2.2
	rm ${S}/m4/lib-link.m4 || true
}

SRC_URI[md5sum] = "d1493d1219b836a8cbf54f4fba962420"
SRC_URI[sha256sum] = "5f49e6353fdc855834b5beb054b3a47ef5fa558006c7eda6d2ec07b36315c2ab"
