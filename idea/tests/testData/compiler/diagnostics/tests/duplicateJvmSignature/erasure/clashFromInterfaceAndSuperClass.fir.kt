// !DIAGNOSTICS: -UNUSED_PARAMETER

public open class A<T> {
    fun foo(x: T) = "O"
    fun foo(x: A<T>) = "K"
}

interface C<E> {
    fun foo(x: E): String
    fun foo(x: A<E>): String
}

interface D {
    fun foo(x: A<String>): String
}

class B1 : A<A<String>>(), D

interface B2 : C<A<String>>, D
