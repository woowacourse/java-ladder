package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import ladder.error.ErrorMessage;

public class Names {
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
        if (names.size() < MIN_NAMES_COUNT || names.size() > MAX_NAMES_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PEOPLE_NUMBER.getMessage());
        }
    }

    public int lengthOfFirstName(){
        return names.get(0).length();
    }

    public List<Name> getNames() {
        return names;
    }

    public int size() {
        return names.size();
    }

}
