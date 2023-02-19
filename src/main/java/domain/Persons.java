package domain;

import java.util.ArrayList;
import java.util.List;

public class Persons {

    private static final String DUPLICATE_NAME_ERROR = "[ERROR] 중복된 이름입니다.";

    private final List<Person> persons = new ArrayList<>();

    public Persons(List<String> names) {
        validateDuplicateName(names);
        addPerson(names);
    }

    public List<String> getPersonsName() {
        List<String> names = new ArrayList<>();

        for (Person person : persons) {
            names.add(person.getName());
        }
        return names;
    }

    private void validateDuplicateName(List<String> names) {
        if (isDuplicated(names)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    private boolean isDuplicated(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }

    private void addPerson(List<String> names) {
        for (String name : names) {
            persons.add(new Person(name));
        }
    }

}
