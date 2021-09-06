package functional;

import java.util.function.Consumer;

// Consumer it's a functional interface that consume / accepts one input and has no return
// BiConsumer it's the same idea except for it accepts 2 parameters
public class _Consumer {
    public static void main(String[] args) {
        Customer customer = new Customer("Zé roela", "123456789");

        // normal method
        greetCustomer(customer);

        // functional / consumer way
        greetCustomerConsumer.accept(customer);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.name + ", thanks for registering phone " + customer.phone);
    }

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello " + customer.name + ", thanks for registering phone " + customer.phone);

    static class Customer {
        private final String name;
        private final String phone;

        public Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
