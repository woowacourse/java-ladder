package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {
    private static final int MIN_RANGE = 2;
    private static final int MAX_RANGE = 100;
    private static final String NAME_DELIMITER = ",";

    private final List<Name> names;

    public Names(String input) {
        this.names = extractNames(input);
        validate();
    }

    private List<Name> extractNames(String input) {
        return Arrays.stream(input.split(NAME_DELIMITER))
                .map(name -> new Name(name.trim()))
                .collect(Collectors.toList());
    }

    private void validate() {
        validateLength();
        validateDuplication();
    }

    private void validateDuplication() {
        Set<String> set = names.stream()
                .map(Name::getName)
                .collect(Collectors.toSet());

        if (set.size() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 입력할 수 없습니다.");
        }
    }

    private void validateLength() {
        int nameSize = names.size();

        if (nameSize < MIN_RANGE || nameSize > MAX_RANGE) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d명 이상 %d명 이하의 사람 수를 입력해 주세요.", MIN_RANGE, MAX_RANGE)
            );
        }
    }

    public List<Name> getNames() {
        return names;
    }

    public int getNamesSize() {
        return names.size();
    }
}
