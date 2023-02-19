package laddergame.domain.ladder;

import laddergame.domain.exception.BlankException;

public class LadderResultName {

    private static final String LADDER_RESULT_NAME = "사다리 결과 이름은";

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
            throw new BlankException(LADDER_RESULT_NAME);
        }
    }
}
