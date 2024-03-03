package domain;

public enum Bridge {
    EXIST(true),
    BLANK(false);

    private final boolean isExist;

    Bridge(boolean isExist) {
        this.isExist = isExist;
    }

    public static Bridge from(BooleanGenerator booleanGenerator) {
        if (booleanGenerator.generate()) {
            return EXIST;
        }
        return BLANK;
    }

    public boolean isExist() {
        return isExist;
    }
}
