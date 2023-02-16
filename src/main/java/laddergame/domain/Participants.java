package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

import static laddergame.messsages.ExceptionMessages.PARTICIPANTS_EMPTY_EXCEPTION;
import static laddergame.messsages.ExceptionMessages.PARTICIPANTS_NULL_EXCEPTION;

public class Participants {
    private final List<Name> names;

    public Participants(final List<Name> names) {
        validateNotNull(names);
        validateNotEmpty(names);
        this.names = names;
    }

    private void validateNotEmpty(final List<Name> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(PARTICIPANTS_EMPTY_EXCEPTION.getMessage());
        }
    }

    private void validateNotNull(final List<Name> names) {
        if (names == null) {
            throw new IllegalArgumentException(PARTICIPANTS_NULL_EXCEPTION.getMessage());
        }
    }

    public int getSize() {
        return names.size();
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getValue)
                .collect(Collectors.toUnmodifiableList());
    }
}
