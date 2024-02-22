package ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class People {

    private static final int MIN_PEOPLE_COUNT = 2;

    private final List<Person> people;

    public People(List<String> names) {
        validate(names);
        people = names.stream()
                .map(Person::new)
                .toList();
    }

    private void validate(List<String> names) {
        validatePeopleCount(names);
        validateDuplicatedName(names);
    }

    private void validatePeopleCount(List<String> names) {
        if (names.size() < MIN_PEOPLE_COUNT) {
            throw new IllegalArgumentException("참여자는 최소 %d명입니다.".formatted(MIN_PEOPLE_COUNT));
        }
    }


    private void validateDuplicatedName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

    public int count() {
        return people.size();
    }

    public Stream<Person> stream() {
        return people.stream();
    }
}
