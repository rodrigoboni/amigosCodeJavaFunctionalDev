package functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        // normal method
        int increment = incrementByOne(1);
        System.out.println(increment);

        // function
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiplyBy10 = multiplyBy10Function.apply(1);
        System.out.println(multiplyBy10);

        // combining functions
        Function<Integer, Integer> mergedFunction = incrementByOneFunction.andThen(multiplyBy10Function);
        int merged = mergedFunction.apply(1);
        System.out.println(merged);

        // bifunction (2 inputs)
        int bifunctionResult = incrementByOneAndMultiplyByFunction.apply(10, 5);
        System.out.println(bifunctionResult);
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> ++number;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyByFunction = (numberToIncrement, numberToMultiply) -> (numberToIncrement + 1) * numberToMultiply;

    static int incrementByOne(int value) {
        return value + 1;
    }
}
