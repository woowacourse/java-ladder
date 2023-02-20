package domain;

public enum Bridge {
    EXIST(true),
    EMPTY(false);

    private final boolean status;

    Bridge(boolean generateResult) {
        this.status = generateResult;
    }

    public boolean getStatus() {return status;}
}
