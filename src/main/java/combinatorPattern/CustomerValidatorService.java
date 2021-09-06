package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;

// Traditional code style
// It works, but if a new validation is added then the public method has to been changed
// And this way it's not so out of box to return what validations have failed
public class CustomerValidatorService {

    private boolean isEmailValid(String email) {
        return email.matches("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+");
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$");
    }

    private boolean isAdult(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears() >= 18;
    }

    public boolean isCustomerValid(Customer customer) {
        return isEmailValid(customer.getEmail()) && isPhoneNumberValid(customer.getPhoneNumber()) && isAdult(customer.getDateOfBirth());
    }
}
