package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        // imperative way
        List<Person> people = List.of(new Person("Rodrigo", MALE),
                new Person("Xan", FEMALE),
                new Person("Zé ruela", MALE),
                new Person("Maria ruela", FEMALE));

        List<Person> females = new ArrayList<>();
        for(Person person : people) {
            if(FEMALE.equals(person.getGender())) {
                females.add(person);
            }
        }

        System.out.println("Imperative way");
        System.out.println(females);

        // declarative way
        System.out.println("Declarative way");
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.getGender());
        people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}

