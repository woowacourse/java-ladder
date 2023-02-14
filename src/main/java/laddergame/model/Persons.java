package laddergame.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Persons {
    private final List<Person> persons;

    public Persons(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException();
        }

        Set<String> removeDuplicateNames = new HashSet<>(names);
        if (removeDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException();
        }
        this.persons = new ArrayList<>();
    }
}
