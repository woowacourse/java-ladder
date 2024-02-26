package laddergame.domain.target;

import laddergame.util.InputValidator;

import java.util.Objects;

public class Target {
    private final String result;

    public Target(final String result) {
        InputValidator.validateBlank(result);
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Target target = (Target) o;
        return Objects.equals(result, target.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
