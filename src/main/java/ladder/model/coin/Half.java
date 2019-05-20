package ladder.model.coin;

public class Half implements Coin {
    private static final double HALF = 0.5;

    @Override
    public boolean toss() {
        return Math.random() >= HALF;
    }
}