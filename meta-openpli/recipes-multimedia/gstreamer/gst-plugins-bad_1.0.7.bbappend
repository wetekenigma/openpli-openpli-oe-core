DEPENDS := "${@oe_filter_out('librsvg', '${DEPENDS}', d)}"

PRINC = "4"

DEPENDS += "libmms librtmp"

# build gst-plugins-bad without orc support for now, to avoid compile errors
EXTRA_OECONF += "--with-plugins="
# fix "configure: error: cannot run test program while cross compiling"
EXTRA_OECONF += "--disable-mpeg2enc --disable-mplex"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"
