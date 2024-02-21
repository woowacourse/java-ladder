package domain;

import java.util.List;

public class Names {
    private static final int EMPTY_NAME_COUNT = 0;
    private static final int FIRST_INDEX = 0;

    private final List<Name> names;

    public Names(List<String> rawNames) {
        validateNameDuplication(rawNames);
        validateNameCount(rawNames);
        this.names = createNames(rawNames);
    }

    private void validateNameCount(List<String> rawNames) {
        if (rawNames.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    private List<Name> createNames(List<String> names) {
        return names.stream()
                .map(Name::new)
                .toList();
    }

    private void validateNameDuplication(List<String> rawNames) {
        if (hasDuplicatedName(rawNames)) {
            throw new IllegalArgumentException();
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

    public String firstName() {
        if (names == null || names.isEmpty()) {
            return "";
        }
        return names.get(FIRST_INDEX).getValue();
    }

    public String nameOf(int index) {
        return names.get(index).getValue();
    }
}
