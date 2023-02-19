package domain;

import java.util.List;
import java.util.stream.Collectors;

public class People {
    public static final int MIN_PERSON_COUNT = 2;

    private final List<Person> people;

    public People(List<String> names) {
        List<Person> people = names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
        validatePersonCount(people);
        this.people = people;
    }

    public List<String> getNames() {
        return people.stream()
            .map(Person::getName)
            .collect(Collectors.toList());
    }

    private void validatePersonCount(List<Person> people) {
        if (people.size() < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException(
                    String.format("사람은 %d명 이상이어야 합니다.", MIN_PERSON_COUNT));
        }
    }

    public int getCount() {
        return people.size();
    }
}
