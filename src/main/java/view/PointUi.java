package view;

public enum PointUi {
    EXIST("-"),
    NOT_EXIST(" ");

    private final String signature;

    PointUi(String signature) {
        this.signature = signature;
    }

    public static String getPointUi(boolean isExist) {
        if (isExist) {
            return EXIST.signature;
        }
        return NOT_EXIST.signature;
    }

}
