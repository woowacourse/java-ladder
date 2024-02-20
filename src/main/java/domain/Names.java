package domain;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private final List<Name> names;
    public Names(List<String> rawNames) {
        validateNameDuplication(rawNames);
        this.names = new ArrayList<>();
    }

    private void validateNameDuplication(List<String> rawNames) {
        if (hasDuplicatedName(rawNames)) {
            throw new IllegalArgumentException();
        };
    }

    private boolean hasDuplicatedName(List<String> rawNames) {
        return getDistinctCount(rawNames) != rawNames.size();
    }

    private int getDistinctCount(List<String> names) {
        return (int) names.stream()
                .distinct()
                .count();
    }
}
