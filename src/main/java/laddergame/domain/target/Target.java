package laddergame.domain.target;

import laddergame.util.InputValidator;

import java.util.Objects;

public class Target {
    private final String target;

    public Target(final String result) {
        InputValidator.validateBlank(result);
        this.target = result;
    }

    public String getTarget() {
        return target;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Target target = (Target) o;
        return Objects.equals(this.target, target.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(target);
    }
}
