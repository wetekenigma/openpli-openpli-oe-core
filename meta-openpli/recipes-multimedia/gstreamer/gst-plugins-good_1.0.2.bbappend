DEPENDS := "${@oe_filter_out('^(gconf|pulseaudio)$', '${DEPENDS}', d)}"
DEPENDS := "${@oe_filter_out('gtk+', '${DEPENDS}', d)}"

PRINC = "3"

EXTRA_OECONF += "--enable-orc"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"
