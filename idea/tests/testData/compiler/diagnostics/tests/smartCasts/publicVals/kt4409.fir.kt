public interface A {
    public val x: Any
}

public class B(override public val x: Any) : A {
    fun foo(): Int {
        if (x is String) {
            return x.length
        } else {
            return 0
        }
    }
}