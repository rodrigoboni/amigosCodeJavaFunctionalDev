package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static combinatorPattern.CustomerRegistrationValidator.ValidationResult;
import static combinatorPattern.CustomerRegistrationValidator.ValidationResult.*;

// Functional version of validator service
// Creates an interface that extends the Function interface, for receiving a Customer as a parameter and returning an item of result enum
// This examples applies the combinator pattern
public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

    // Returns an implementation of the function interface, for applying some validation
    // As expected, the function receives a Customer and returns an enum item
    // The customer instance if supplied when apply method is called
    // implemented as static for easy of use / not required to create a new instance of validator / turns into a singleton
    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().matches("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+") ? SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears() >= 18 ? SUCCESS : IS_NOT_AN_ADULT;
    }

    // use the default method of interfaces to provide a way to combine validations and validate if all of them are satisfied
    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> { // returns an implementation of the functional interface
            ValidationResult result = this.apply(customer); // this refers to the current instance of function
            return result.equals(SUCCESS) ? other.apply(customer) : result; // if the current instance of function it's satisfied then verify the other validation - else return the result
        };
    }

    static List<ValidationResult> validateAll(List<CustomerRegistrationValidator> validators, Customer customer) {
        return validators.stream().map(validator -> validator.apply(customer)).collect(Collectors.toList());
    }

    static boolean isAllValid(List<ValidationResult> validationResults) {
        return validationResults.stream().allMatch(result -> result.equals(SUCCESS));
    }

    static List<ValidationResult> getValidationErrors(List<ValidationResult> validationResults) {
        return validationResults.stream().filter(result -> !result.equals(SUCCESS)).collect(Collectors.toList());
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
