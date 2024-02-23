package domain;

import util.ExceptionMessages;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private static final int MINIMUM_PLAYERS_COUNT = 2;
    private static final int MAXIMUM_PLAYERS_COUNT = 10;

    private final List<Name> names = new ArrayList<>();

    public Players(final List<String> names) {
        validateNameCount(names.size());
        for (final String name : names) {
            this.names.add(new Name(name));
        }
    }

    private void validateNameCount(final int count) {
        if (count < MINIMUM_PLAYERS_COUNT || count > MAXIMUM_PLAYERS_COUNT) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYERS_COUNT);
        }
    }

    public int count() {
        return names.size();
    }

    public List<String> getNames() {
        final List<String> names = new ArrayList<>();
        for (final Name name : this.names) {
            names.add(name.getValue());
        }

        return names;
    }
}
