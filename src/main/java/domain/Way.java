package domain;


public enum Way {
    PASS( "-", true),
    NOT_PASS(" ", false);

    private final String way;
    private final boolean isExist;

    Way( String way, boolean isExist) {
        this.way = way;
        this.isExist = isExist;
    }

    public static String tranceFrom(boolean isExist) {
        if (isExist == PASS.isExist) {
            return PASS.way;
        }
        return NOT_PASS.way;
    }

}

