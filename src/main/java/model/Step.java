package model;

import java.util.Objects;


//TODO: connected 로 변경하기
public class Step {

    private final boolean hasStep;

    public Step(final boolean hasStep) {
        this.hasStep = hasStep;
    }

    public boolean hasStep() {
        return hasStep;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hasStep);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Step step)) {
            return false;
        }
        return hasStep == step.hasStep;
    }
}
