package domain;

public enum StepPoint {

    PRESENT(true),
    ABSENT(false);

    private final boolean isExist;

    StepPoint(boolean isExist) {
        this.isExist = isExist;
    }

    public boolean isExist() {
        return this.isExist;
    }
}
