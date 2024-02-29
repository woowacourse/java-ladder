package domain.player;

import domain.common.Name;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Names {
    private static final Integer MINIMUM_SIZE = 2;
    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names from(List<String> names) {
        validate(names);
        return new Names(names.stream()
                              .map(Name::new)
                              .toList());
    }

    private static void validate(List<String> names) {
        validateSize(names);
        validateDuplicated(names);
    }

    private static void validateDuplicated(List<String> names) {
        Set<String> duplicateSize = new HashSet<>(names);
        if (duplicateSize.size() != names.size()) {
            throw new IllegalArgumentException("중복된 이름이 포함되어 있습니다.");
        }
    }

    private static void validateSize(List<String> names) {
        if (names.size() < MINIMUM_SIZE) {
            throw new IllegalArgumentException(String.format("최소 %d명 이상의 이름을 입력해주세요.", MINIMUM_SIZE));
        }
    }

    public List<Name> getNames() {
        return names;
    }
}
