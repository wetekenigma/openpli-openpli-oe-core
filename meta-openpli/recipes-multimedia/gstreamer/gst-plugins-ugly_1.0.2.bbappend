PRINC = "2"

DEPENDS += "opencore-amr libcdio"

EXTRA_OECONF += "--enable-orc --with-plugins="

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"
