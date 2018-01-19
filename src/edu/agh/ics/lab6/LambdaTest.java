package edu.agh.ics.lab6;

import edu.agh.ics.lab5.Person;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
//        Person[] persons = {
//                new Person("Jan", "Kowalski", "1"),
//                new Person("Andrzej", "Zima", "2"),
//                new Person("Adam", "Mickiewicz", "3"),
//                new Person("Bolesław", "Prus", "4")
//        };
//
//        //
//        // comparator - anonimowa klasa wewnętrzna
//        //
//        Comparator<Person> compA = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getFirstName().compareTo(o2.getFirstName());
//            }
//        };
//        Comparator<Person> compB = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getLastName().length() - o2.getLastName().length();
//            }
//        };
//
//        //
//        // comparator - lambda
//        //
//        Comparator<Person> compC = (pa, pb) -> pa.getFirstName().length() - pb.getFirstName().length();
//
//        Arrays.sort(persons, compC);
//        System.out.println(Arrays.toString(persons));
//
//        //
//        // comparator - referencja do zewnętrznej metody
//        //
//        ComparisonProvider comparisonProvider = new ComparisonProvider();
//        Arrays.sort(persons, comparisonProvider::compareByFirstName);
//        System.out.println(Arrays.toString(persons));
//        Arrays.sort(persons, ComparisonProvider::compareByLastName);
//        System.out.println(Arrays.toString(persons));


        List<Person> people = Arrays.asList(
                new Person("Jan", "Kowalski", "1"),
                new Person("Andrzej", "Zima", "2"),
                new Person("Adam", "Mickiewicz", "3"),
                new Person("Bolesław", "Prus", "4")
        );

        Collections.sort(people, (pa, pb) -> pa.getLastName().length() - pb.getLastName().length());
        System.out.println(people);
        Collections.sort(people, (pa, pb) -> pb.getFirstName().length() - pa.getFirstName().length());
        System.out.println(people);

        ComparisonProvider comparisonProvider = new ComparisonProvider();
        Collections.sort(people, comparisonProvider::compareByFirstName);
        System.out.println(people);


        people.forEach(System.out::println);
        people.forEach(p -> System.out.println(p.getFirstName() + " "));

        System.out.println(people.stream().filter(p -> p.getLastName().startsWith("Ko")).count());
        List<Person> ko = people.stream().filter(p -> p.getLastName().startsWith("Ko")).collect(Collectors.toList());
        System.out.println(ko);

        System.out.println(people.stream().map(p -> p.getFirstName().length()).reduce((x, y) -> x + y).get());
        System.out.println(people.stream().map(p -> p.getFirstName().length()).max(Integer::compareTo).get());
    }
}
