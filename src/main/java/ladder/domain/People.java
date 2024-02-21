package ladder.domain;

import java.util.List;

public class People {

    List<String> people;

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
        if (names.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요.");
        }
    }

    private void validateDuplicatedName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

}
