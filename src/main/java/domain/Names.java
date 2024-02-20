package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Names {
    private final List<Name> names;
    public Names(List<String> rawNames) {
        validateNameDuplication(rawNames);
        this.names = new ArrayList<>();
    }

    private void validateNameDuplication(List<String> rawNames) {
        if (getDistinctCount(rawNames) != rawNames.size()) {
            throw new IllegalArgumentException();
        };
    }

    private static int getDistinctCount(List<String> names) {
        return (int) names.stream()
                .distinct()
                .count();
    }
}
