package callback;

import java.util.function.Consumer;

// example of using functional interface to implement callback like in JS
// in hello() the Consumer interface is applied (when it receives one parameter and returns nothing)
// in hello2() the Runnable interface is applied (when no parameter exists)
public class Main {
    public static void main(String[] args) {

        hello("Zé", "Ruela", (value) -> System.out.println("No lastname for " + value));
        hello("Zé", null, (value) -> System.out.println("No lastname for " + value));

        hello2("Zé", "Ruela", () -> System.out.println("no lastname"));
        hello2("Zé", null, () -> System.out.println("no lastname"));
    }

    static void hello(String name, String lastName, Consumer<String> callback) {
        System.out.println(name);
        if(lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(name);
        }
    }

    static void hello2(String name, String lastName, Runnable callback) {
        System.out.println(name);
        if(lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
