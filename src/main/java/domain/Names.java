package domain;

import java.util.List;

public class Names {
    private final List<Name> names;

    public Names(List<String> rawNames) {
        validateNameDuplication(rawNames);
        this.names = createNames(rawNames);
    }

    private List<Name> createNames(List<String> names) {
        return names.stream().map(Name::new).toList();
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

    public List<Name> getNames() {
        return names;
    }

    public Name getFirstName() {
        return names.get(0);
    }

    public String getName(int index) {
        return names.get(index).getName();
    }
}
