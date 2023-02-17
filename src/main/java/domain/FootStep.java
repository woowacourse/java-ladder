package domain;

public class FootStep {
    private final boolean steppable;

    private FootStep(final boolean steppable) {
        this.steppable = steppable;
    }

    public static FootStep of(final boolean steppable) {
        return new FootStep(steppable);
    }

    public boolean isSteppable() {
        return steppable;
    }

    @Override
    public String toString() {
        return "FootStep{" +
                "steppable=" + steppable +
                '}';
    }
}
