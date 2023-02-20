package domain;

public enum Bridge {

    EXIST, EMPTY;

    public boolean isSerialWith(Bridge next) {
        return this.doesExist() && next.doesExist();
    }

    public boolean doesExist() {
        return this == EXIST;
    }
}
