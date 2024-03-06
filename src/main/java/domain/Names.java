package domain;

import java.util.List;

public class Names {
    private static final int EMPTY_NAME_COUNT = 0;
    private static final int FIRST_INDEX = 0;
    private static final int MIN_NAMES_COUNT = 2;

    private final List<Name> names;

    public Names(List<String> rawNames) {
        validateNameDuplication(rawNames);
        validateNameCount(rawNames);
        this.names = createNames(rawNames);
    }

    private void validateNameCount(List<String> rawNames) {
        if (rawNames.size() < MIN_NAMES_COUNT) {
            throw new IllegalArgumentException("이름은 2개 이상 입력해야 합니다.");
        }
    }

    private void validateNameDuplication(List<String> rawNames) {
        if (hasDuplicatedName(rawNames)) {
            throw new IllegalArgumentException("이름은 중복하여 입력할 수 없습니다.");
        }
    }

    private List<Name> createNames(List<String> names) {
        return names.stream()
                .map(Name::new)
                .toList();
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

    public String firstName() {
        if (names == null || names.isEmpty()) {
            return "";
        }
        return names.get(FIRST_INDEX).getValue();
    }

    public String nameOf(int index) {
        return names.get(index).getValue();
    }

    public List<Name> getNames() {
        return names;
    }
}
