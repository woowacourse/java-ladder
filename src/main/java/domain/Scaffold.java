package domain;

public enum Scaffold {

    EXIST(true),
    NONE(false);

    private final boolean status;

    Scaffold(final boolean status) {
        this.status = status;
    }

    public boolean isExist() {
        return this == EXIST;
    }
}
