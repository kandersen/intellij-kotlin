// !WITH_NEW_INFERENCE
// !DIAGNOSTICS: -UNUSED_PARAMETER

class A<T>

operator fun <T> T.invoke(a: A<T>) {}

fun foo(s: String, ai: A<Int>) {
    1(ai)

    <!TYPE_INFERENCE_CONFLICTING_SUBSTITUTIONS{OI}!>s<!>(<!TYPE_MISMATCH{NI}!>ai<!>)

    <!TYPE_INFERENCE_CONFLICTING_SUBSTITUTIONS{OI}!>""<!>(<!TYPE_MISMATCH{NI}!>ai<!>)
}
