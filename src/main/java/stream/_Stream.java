package stream;

import java.util.List;
import java.util.stream.Collectors;

import static stream._Stream.Gender.FEMALE;
import static stream._Stream.Gender.MALE;

// Stream it's a functional interface that process an input, apply one or more filters and / or transformations and produces a result stream / collection / value
// Stream uses all other functional interfaces (consumer, predicates etc)
public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Rodrigo", MALE),
                new Person("Xan", FEMALE),
                new Person("Zé ruela", MALE),
                new Person("Maria ruela", FEMALE));

        people.stream()
                .map(person -> person.gender) // transform each Person instance into a stream of Gender - uses a function to receive a parameter and return a value
                .collect(Collectors.toSet()) // transform stream in a collection (set doesn't allow duplicates, appropriate for collecting gender enum items)
                .forEach(System.out::println); // apply a consumer to foreach method to receive each gender of collection and prints in stdout (with no return)

        people.stream()
                .map(person -> person.name) // transform each Person instance into a stream of Gender - uses a function to receive a parameter and return a value
                .mapToInt(String::length) // example of mapping to integer when collecting length of names in stream
                .forEach(System.out::println); // apply a consumer to foreach method to receive each gender of collection and prints in stdout (with no return)
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
