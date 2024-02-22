package ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class People {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final List<String> people;

    public People(List<String> names) {
        validate(names);
        people = names.stream()
                .map(String::new)
                .toList();
    }

    private void validate(List<String> names) {
        validateNameLength(names);
        validateDuplicatedName(names);
    }

    private void validateNameLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(
                    "이름은 %d~%d글자로 입력해주세요.".formatted(MIN_NAME_LENGTH, MAX_NAME_LENGTH));
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

    public Stream<String> stream() {
        return people.stream();
    }
}
