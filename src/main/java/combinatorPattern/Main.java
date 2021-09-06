package combinatorPattern;

import java.time.LocalDate;
import java.util.List;

import static combinatorPattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Meg", "megdogs.net", "+1655988030567", LocalDate.of(2009, 01, 01));

        // using non functional way of applying validation rules
        CustomerValidatorService customerValidatorService = new CustomerValidatorService();
        System.out.println("non functional validation result: " + customerValidatorService.isCustomerValid(customer));

        // functional way with combinator pattern
        // combining validations and applying a customer to it
        ValidationResult result = isEmailValid().and(isPhoneNumberValid()).and(isAdult()).apply(customer);
        System.out.println("validation result: " + result);

        // functional way can be used to lazily execute / apply some value
        // for instance in this function results from combination of isEmailValid and isPhoneNumberValid validators
        CustomerRegistrationValidator customerRegistrationValidator = isEmailValid().and(isPhoneNumberValid());
        if (true) { // if some condition is met
            customerRegistrationValidator = customerRegistrationValidator.and(isAdult()); // another validation is added
        }
        ValidationResult validationResult = customerRegistrationValidator.apply(customer); // and finally apply the customer instance for validation
        System.out.println("conditional validation result: " + validationResult);

        List<ValidationResult> validationResults = validateAll(List.of(isEmailValid(), isPhoneNumberValid(), isAdult()), customer);
        System.out.println("all validation results: " + validationResults);
        System.out.println("all valid result :" + isAllValid(validationResults));
        System.out.println("validation errors :" + getValidationErrors(validationResults));
    }
}
