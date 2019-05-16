package laddergame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Members {
    private List<Person> people;

    public Members(List<String> names) {
        if (hasDuplicateName(names)) {
            throw new IllegalArgumentException("중복된 이름은 불가능합니다.");
        }
        this.people = names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    private boolean hasDuplicateName(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        return names.size() != nonDuplicateNames.size();
    }
}
