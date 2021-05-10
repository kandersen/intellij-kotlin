// !DIAGNOSTICS: -UNUSED_VARIABLE -UNCHECKED_CAST -UNUSED_VALUE -ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE
// !LANGUAGE: +NewInference
// SKIP_TXT

// FILE: Foo.java
import org.jetbrains.annotations.NotNull;

public class Foo<T>  {
    T x;

    public Foo(T x) {
        this.x = x;
    }

    public static Number bar() { return null; }

    public static <K> K simpleId(K k) {
        return k;
    }

    public T produceT() {
        return x;
    }

    @NotNull
    public T produceNotNullT() {
        return x;
    }

    public void consumeT(T x) {}
}

// FILE: main.kt
fun <T> bar(n: Number?, d: T, e: T) {
    val a: Number = <!INITIALIZER_TYPE_MISMATCH!>Foo.simpleId(n)<!>
    val b: Number? = Foo.simpleId(n)
    val c = Foo.simpleId(n)

    val x4 = Foo(if (true) 10 else null)
    val x5: Number = <!INITIALIZER_TYPE_MISMATCH!>x4.produceT()<!>
    val x6: Number? = x4.produceT()
    val x7 = x4.produceT()
    val x8 = x4.produceNotNullT()

    x4.consumeT(x7)

    val x9: T = Foo.simpleId(d)
    val x10: T? = Foo.simpleId(d)

    if (e != null) {
        var x11 = e
        x11 = Foo.simpleId(d) // assign to definitely not-null T, the lack an error is consistent with old inference
    }

    var x11 = Foo<T>(null as T).x
    x11 = Foo.simpleId(d) // assign to flexible T

    var x12 = Foo.bar()
    x12 = Foo.simpleId(n) // assign to flexible Number

    var x13 = e
    x13 = Foo.simpleId(d)
}
