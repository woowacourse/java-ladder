package domain;

public class Leg {

    private boolean isExist;

    private Leg(boolean leg) {
        this.isExist = leg;
    }

    public static Leg from(boolean isExist) {
        return new Leg(isExist);
    }

    public boolean isExist() {
        return isExist;
    }
}
