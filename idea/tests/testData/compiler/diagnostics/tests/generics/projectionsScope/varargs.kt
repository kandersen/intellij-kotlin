// !WITH_NEW_INFERENCE
// !DIAGNOSTICS: -UNUSED_PARAMETER

class A<T> {
    fun foo(vararg x: T) {}
}

fun test(a: A<out CharSequence>, y: Array<out CharSequence>) {
    a.<!MEMBER_PROJECTED_OUT{OI}!>foo<!>(<!TYPE_MISMATCH{NI}!>""<!>, <!TYPE_MISMATCH{NI}!>""<!>, <!TYPE_MISMATCH{NI}!>""<!>)
    a.foo(*<!TYPE_MISMATCH{NI}, TYPE_MISMATCH_DUE_TO_TYPE_PROJECTIONS{OI}!>y<!>)
    // TODO: TYPE_MISMATCH_DUE_TO_TYPE_PROJECTIONS probably redundant
    a.<!MEMBER_PROJECTED_OUT{OI}!>foo<!>(*<!TYPE_MISMATCH{NI}, TYPE_MISMATCH_DUE_TO_TYPE_PROJECTIONS{OI}!>y<!>, <!TYPE_MISMATCH{NI}!>""<!>)
}
