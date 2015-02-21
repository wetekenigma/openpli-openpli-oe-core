
ENIGMA2_BRANCH ?= "amlogic"
# This is kind of a hack to clone private repo. Maybe someone have a better solution
SRC_URI = "git://github.com/wetekenigma/openpli-enigma2.git;protocol=ssh;user=git;branch=${ENIGMA2_BRANCH}"
