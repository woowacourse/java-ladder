package domain;

public enum Bridge {

    EXIST, EMPTY;

    public boolean isSerialWith(Bridge next) {
        return this == EXIST && next == EXIST;
    }

    public boolean doesExist() {
        return this == EXIST;
    }
}
