package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import ladder.error.ErrorMessage;

public class Names {
    private static final int FIRST_NAME_INDEX = 0;
    private static final int MIN_NUMBER_OF_PEOPLE = 2;
    private static final int MAX_NUMBER_OF_PEOPLE = 100;

    private final List<Name> names;

    public Names(List<String> names) {
        validate(names);

        this.names = names.stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

    public int lengthOfFirstName() {
        return names.get(FIRST_NAME_INDEX).length();
    }

    public List<Name> getNames() {
        return names;
    }

    public int size() {
        return names.size();
    }

    private void validate(List<String> names) {
        validateNumberOfPeople(names);
    }

    private void validateNumberOfPeople(List<String> names) {
        if (names.size() < MIN_NUMBER_OF_PEOPLE || names.size() > MAX_NUMBER_OF_PEOPLE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PEOPLE_COUNT.getMessage());
        }
    }
}
