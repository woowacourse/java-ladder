package domain;

public enum StepPoint {
    PRESENT(true),
    ABSENT(false);

    private final Boolean isExist;

    StepPoint(boolean isExist) {
        this.isExist = isExist;
    }

    public boolean isExist() {
        return isExist;
    }

}
