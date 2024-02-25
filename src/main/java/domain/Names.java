package domain;

import java.util.List;

public class Names {
    private static final int EMPTY_NAME_COUNT = 0;
    private static final int MIN_NAMES_COUNT = 2;
    private static final String INVALID_NAMES = "이름은 " + MIN_NAMES_COUNT + "개 이상의 중복되지 않은 값이어야 합니다.";

    private final List<Name> names;

    public Names(List<String> rawNames) {
        validateNameDuplication(rawNames);
        validateNameCount(rawNames);
        this.names = createNames(rawNames);
    }

    private void validateNameCount(List<String> rawNames) {
        if (rawNames.size() < MIN_NAMES_COUNT) {
            throw new IllegalArgumentException(INVALID_NAMES);
        }
    }

    private List<Name> createNames(List<String> names) {
        return names.stream()
                .map(Name::new)
                .toList();
    }

    private void validateNameDuplication(List<String> rawNames) {
        if (hasDuplicatedName(rawNames)) {
            throw new IllegalArgumentException(INVALID_NAMES);
        }
    }

    private boolean hasDuplicatedName(List<String> rawNames) {
        return getDistinctCount(rawNames) != rawNames.size();
    }

    private int getDistinctCount(List<String> names) {
        return (int) names.stream()
                .distinct()
                .count();
    }

    public int size() {
        if (names == null || names.isEmpty()) {
            return EMPTY_NAME_COUNT;
        }
        return names.size();
    }

    public String nameOf(int index) {
        return names.get(index).getValue();
    }
}
