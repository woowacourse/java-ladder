package laddergame.domain;

import static laddergame.domain.Player.NAME_BLANK_ERROR;

public record Result(String name) {
    public Result {
        validate(name);
    }

    private void validate(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR);
        }
    }
}
