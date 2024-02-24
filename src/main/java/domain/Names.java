package domain;

import util.ExceptionMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Names {

    private static final int MINIMUM_PLAYERS_COUNT = 2;
    private static final int MAXIMUM_PLAYERS_COUNT = 10;

    private final List<Name> values = new ArrayList<>();

    public Names(final List<String> values) {
        validateNameCount(values.size());
        for (final String name : values) {
            this.values.add(new Name(name));
        }
    }

    private void validateNameCount(final int count) {
        if (count < MINIMUM_PLAYERS_COUNT || count > MAXIMUM_PLAYERS_COUNT) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYERS_COUNT);
        }
    }

    public int count() {
        return values.size();
    }

    public List<String> getValues() {
        final List<String> names = new ArrayList<>();
        for (final Name name : this.values) {
            names.add(name.getValue());
        }

        return names;
    }
}
