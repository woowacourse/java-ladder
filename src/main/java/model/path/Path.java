package model.path;

public enum Path {
    EXIST(true),
    NOT_EXIST(false);

    private final boolean isExist;

    Path(boolean isExist) {
        this.isExist = isExist;
    }

    public boolean isExist() {
        return isExist;
    }
}
