package combinatorPattern;

import java.time.LocalDate;

public class Customer {
    private final String Name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dateOfBirth;

    public Customer(String name, String email, String phoneNumber, LocalDate dateOfBirth) {
        Name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
