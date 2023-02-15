package domain;

public class FootStep {
    private final boolean steppable;

    public FootStep(final boolean steppable) {
        this.steppable = steppable;
    }

    public boolean isSteppable() {
        return steppable;
    }
}
