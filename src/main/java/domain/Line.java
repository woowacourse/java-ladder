package domain;

public enum Line {

    EXIST,
    NOT_EXIST;

    public static Line from(boolean isExist) {
        if (isExist) {
            return EXIST;
        }
        return NOT_EXIST;
    }
}
