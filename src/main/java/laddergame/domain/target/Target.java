package laddergame.domain.target;

import laddergame.util.InputValidator;

public class Target {
    private final String result;

    public Target(final String result) {
        InputValidator.validateBlank(result);
        this.result = result;
    }
}
