package ladder.domain;

import ladder.error.ErrorMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final int FIRST_NAME_INDEX = 0;
    private static final int MIN_NAMES_COUNT = 2;
    private static final int MAX_NAMES_COUNT = 100;

    private final List<Name> names;

    public Names(List<String> names) {
        validate(names);

        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        validateCountOfNames(names);
        validateDuplicateNames(names);
    }

    private void validateCountOfNames(List<String> names) {
        if (names.size() < MIN_NAMES_COUNT || names.size() > MAX_NAMES_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PEOPLE_COUNT.getMessage());
        }
    }

    private void validateDuplicateNames(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAMES.getMessage());
        }
    }

    public int lengthOfFirstName() {
        return names.get(FIRST_NAME_INDEX).length();
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    public int size() {
        return names.size();
    }
}
