// !WITH_NEW_INFERENCE
// !DIAGNOSTICS: -UNUSED_VARIABLE

fun main() {
    val x = <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{NI}!>run<!> { <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{NI}!>::<!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>run<!><!> } // no error
}
