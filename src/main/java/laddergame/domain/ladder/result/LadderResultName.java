package laddergame.domain.ladder.result;

import laddergame.domain.exception.ladder.result.LadderResultNameBlankException;

public class LadderResultName {

    private final String name;

    private LadderResultName(final String name) {
        validateNameBlank(name);
        this.name = name;
    }

    public static LadderResultName create(final String name) {
        return new LadderResultName(name);
    }

    private void validateNameBlank(final String name) {
        if (name.isBlank()) {
            throw new LadderResultNameBlankException();
        }
    }

    public String getName() {
        return name;
    }
}
