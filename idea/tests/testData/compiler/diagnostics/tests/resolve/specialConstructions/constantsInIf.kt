// !WITH_NEW_INFERENCE
// !DIAGNOSTICS: -USELESS_ELVIS

fun test() {
    bar(<!TYPE_MISMATCH{NI}, TYPE_MISMATCH{NI}!>if (true) {
        <!CONSTANT_EXPECTED_TYPE_MISMATCH{OI}!>1<!>
    } else {
        <!CONSTANT_EXPECTED_TYPE_MISMATCH{OI}!>2<!>
    }<!>)

    bar(<!TYPE_MISMATCH{NI}, TYPE_MISMATCH{NI}, TYPE_MISMATCH{NI}, TYPE_MISMATCH{NI}!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!> ?: <!CONSTANT_EXPECTED_TYPE_MISMATCH!>2<!><!>)
}

fun bar(s: String) = s
