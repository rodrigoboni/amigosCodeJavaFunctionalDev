package functional;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberWithDDD.test("16988030567", "16"));

        // predicates can be combined to apply tests - "or" can be used instead of "and"
        System.out.println(isPhoneNumberValid.and(isBrazilPhoneNumber).test("+5516988030567"));
    }

    // like other interfaces, predicate has the BiPredicate interface that allows 2 input parameters
    static BiPredicate<String, String> isPhoneNumberWithDDD = (number, ddd) -> number.startsWith(ddd);

    static Predicate<String> isBrazilPhoneNumber = number -> number.startsWith("+55");
    static Predicate<String> isPhoneNumberValid = number -> number.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,7}$");
}
