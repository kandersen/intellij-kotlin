fun foo(y: Int): Int {
    return y + 1
}

fun calc(x: List<String>?): Int {
    // x should be non-null in arguments list
    return foo(x?.get(x.size - 1)!!.length)
}
