package domain;

public enum Bridge {
    EXIST,
    BLANK;

    public static boolean isExist(Bridge bridge) {
        return EXIST == bridge;
    }
}
