package ladder.model;

public class Coin {
    public static boolean toss() {
        if (Math.random() >= 0.5) {
            return true;
        }
        return false;
    }
}