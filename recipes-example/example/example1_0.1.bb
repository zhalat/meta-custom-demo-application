SUMMARY = "Simple helloworld application"
SECTION = "examples"
LICENSE = "CLOSED"

python do_display_before_fetching() {
    bb.plain("*************************************************************");
    bb.plain("*  ----  Log before do_fetch()   ---                        *");
    bb.plain("*  Example 'helloworld' recipe from meta-custom-demo-app    *");
    bb.plain("*                                                           *");
    bb.plain("*************************************************************");
}

python do_display_before_compiling() {
    bb.plain("----  Log before do_compile()   ---");
}

python do_display_before_patching() {
    bb.plain("----  Log before do_patch()   ---");
}

SRC_URI = "file://helloworld1.cpp"

# for local files use WORKDIR directly "${WORKDIR}/git" it it were a git repo
S = "${WORKDIR}"     

do_compile() {
    ${CXX} ${CXXFLAGS} ${LDFLAGS} helloworld1.cpp -o helloworld1
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 helloworld1 ${D}${bindir}
}

#remember that multithreading may cause logs to appear in different order
addtask display_before_fetching before do_fetch
addtask display_before_compiling before do_compile
addtask display_before_patching before do_patch