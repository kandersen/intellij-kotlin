// FILE: Annotated.java

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Annotated {
    @NotNull
    public String foo(@Nullable String param) {
        if (param != null) return param;
        else return "";
    }
}

// FILE: jvm.kt

class User : Annotated() {
    fun test() {
        val x = foo("123")
        val y = foo(null)
    }
}

