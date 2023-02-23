package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {
    private static final int MIN_RANGE = 2;
    private static final int MAX_RANGE = 100;

    private final List<Name> names;

    public Names(List<String> names) {
        validate(names);
        this.names = generateNames(names);
    }

    private void validate(List<String> names) {
        validateLength(names);
        validateDuplication(names);
    }

    private void validateDuplication(List<String> names) {
        Set<String> set = new HashSet<>(names);

        if (set.size() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 입력할 수 없습니다.");
        }
    }

    private void validateLength(List<String> names) {
        int nameSize = names.size();

        if (nameSize < MIN_RANGE || nameSize > MAX_RANGE) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d명 이상 %d명 이하의 사람 수를 입력해 주세요.", MIN_RANGE, MAX_RANGE)
            );
        }
    }

    private List<Name> generateNames(List<String> names) {
        return names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return names;
    }

    public int getNamesSize() {
        return names.size();
    }
}
