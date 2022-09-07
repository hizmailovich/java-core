package io.ylab;

import java.util.*;
import java.util.stream.Collectors;

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
        Map<String, Integer> persons = new TreeMap<>();

        System.out.println("Raw data:\n");

        Arrays.stream(RAW_DATA)
                .peek(person -> persons.put(person.name, person.id))
                .forEach(person -> System.out.println(person.id + " - " + person.name));

        System.out.println("\n**************************************************\n");
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:\n");

        persons.entrySet().stream()
                .peek(person -> {
                    int count = Collections.frequency(Arrays.stream(RAW_DATA)
                            .distinct()
                            .map(Person::getName)
                            .collect(Collectors.toList()), person.getKey());
                    person.setValue(count);
                })
                .forEach(person -> System.out.println("Key: " + person.getKey() + "\nValue:" + person.getValue()));
    }
}