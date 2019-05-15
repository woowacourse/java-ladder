package ladder.model;

public class Coin implements Possible {
    private static final double HALF = 0.5;

    @Override
    public boolean isPossible() {
        if (Math.random() >= HALF) {
            return true;
        }
        return false;
    }
}