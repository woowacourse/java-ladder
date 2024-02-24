package laddergame.domain;

import static laddergame.domain.Player.NAME_BLANK_ERROR;

public class Result {
    private final String name;

    public Result(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR);
        }
    }

    public String getName() {
        return name;
    }
}
