SUMMARY = "GStreamer multimedia framework"
DESCRIPTION = "GStreamer is a multimedia framework for encoding and decoding video and sound. \
It supports a wide range of formats including mp3, ogg, avi, mpeg and quicktime."
HOMEPAGE = "http://gstreamer.freedesktop.org/"
BUGTRACKER = "https://bugzilla.gnome.org/enter_bug.cgi?product=Gstreamer"
SECTION = "multimedia"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=55ca817ccb7d5b5b66355690e9abc605 \
                    file://gst/gst.h;beginline=1;endline=21;md5=8e5fe5e87d33a04479fde862e238eaa4"
DEPENDS = "glib-2.0 libxml2 bison-native flex-native"

PR = "r1"

SRC_URI = "http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-${PV}.tar.xz"

SRC_URI[md5sum] = "1faa5a86feddf87af57e72f42d060b3d"
SRC_URI[sha256sum] = "10c59112bb01a274eb33950300da13d25fd23a7494781bf1b2328372fdb6ee06"

inherit autotools pkgconfig gettext

GSTREAMER_DEBUG ?= "--disable-debug"
EXTRA_OECONF = "--disable-docs-build --disable-dependency-tracking --with-check=no --disable-examples --disable-tests --disable-valgrind ${GSTREAMER_DEBUG}"

RRECOMMENDS_${PN}_qemux86    += "kernel-module-snd-ens1370 kernel-module-snd-rawmidi"
RRECOMMENDS_${PN}_qemux86-64 += "kernel-module-snd-ens1370 kernel-module-snd-rawmidi"

FILES_${PN} += " ${libdir}/gstreamer-1.0/*.so"
FILES_${PN}-dev += " ${libdir}/gstreamer-1.0/*.la ${libdir}/gstreamer-1.0/*.a"
FILES_${PN}-dbg += " ${libdir}/gstreamer-1.0/.debug/ ${libexecdir}/gstreamer-1.0/.debug/"
