// "Add non-null asserted (!!) call" "true"
// WITH_RUNTIME

class C {
    val list: List<String>? = null
}

// Test for KTIJ-10052
fun C.test() {
    for (s in <caret>list) {}
}
