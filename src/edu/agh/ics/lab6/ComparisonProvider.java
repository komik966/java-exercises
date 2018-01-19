package edu.agh.ics.lab6;

import edu.agh.ics.lab5.Person;

public class ComparisonProvider {
    public int compareByFirstName(Person a, Person b) {
        return a.getFirstName().compareTo(b.getFirstName());
    }

    public static int compareByLastName(Person a, Person b) {
        return a.getLastName().compareTo(b.getLastName());
    }
}
