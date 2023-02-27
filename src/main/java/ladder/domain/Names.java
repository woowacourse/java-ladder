package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import ladder.error.ErrorMessage;

public class Names {
    private static final int MIN_NUMBER_OF_NAMES = 2;
    private static final int MAX_NUMBER_OF_NAMES = 100;

    private final List<Name> names;

    public Names(List<String> names) {
        validate(names);

        this.names = names.stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        validateNumberOfNames(names);
    }

    private void validateNumberOfNames(List<String> names) {
        if (names.size() < MIN_NUMBER_OF_NAMES || names.size() > MAX_NUMBER_OF_NAMES) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PEOPLE_COUNT.getMessage());
        }
    }

    public List<Name> getNames() {
        return names;
    }

    public int size() {
        return names.size();
    }

}
