package ladder.domain.laddercomponent;

public class Step {
    private final boolean stepExist;

    public Step(Boolean stepExist) {
        this.stepExist = stepExist;
    }

    public boolean exist() {
        return stepExist;
    }
}
