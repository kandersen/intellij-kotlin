// FIR_IDENTICAL
// !DIAGNOSTICS: -UNUSED_VALUE

fun foo(f: Boolean): Int {
    val i: Int
    if (f) {
        i = 1
    }
    <!VAL_REASSIGNMENT!>i<!> = 3
    return i
}