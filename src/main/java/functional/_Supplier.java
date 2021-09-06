package functional;

import java.util.function.Supplier;

// Supplier is a functional interface that receives no argument and returns some value
// Return type may be any kind of object, list etc
public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getConnectionString());
        System.out.println(getConnectionStringSupplier.get());
    }

    // traditional
    static String getConnectionString() {
        return "jdbc://postgresql/...";
    }

    // functional
    static Supplier<String> getConnectionStringSupplier = () -> "jdbc://postgresql/...";
}
