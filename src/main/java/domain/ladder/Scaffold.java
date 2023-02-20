package domain.ladder;

public enum Scaffold {

    EXIST,
    NONE,
    ;

    public boolean isExist() {
        return this == EXIST;
    }
}
