package io.ylab;

import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    static class Person {
        final int id;
        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"),
            new Person(1, "Harry"),
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        System.out.println("Raw data:\n");

        Arrays.stream(RAW_DATA)
                .forEach(person -> System.out.println(person.id + " - " + person.name));

        System.out.println("\n**************************************************\n");
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:\n");

        Map<String, Long> persons = Arrays.stream(RAW_DATA)
                .distinct()
                .filter(person -> person.getName() != null)
                .sorted(Comparator.comparingInt(Person::getId))
                .collect(groupingBy(Person::getName, counting()));

        persons.forEach((key, value) -> System.out.println("Key: " + key + "\nValue: " + value));
    }
}