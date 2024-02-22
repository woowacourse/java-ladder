package domain;

enum Stick {

    FILLED, EMPTY;

    public static Stick getOpposite(Stick stick) {
        if (stick == FILLED) {
            return EMPTY;
        }

        return FILLED;
    }
}
