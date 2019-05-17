package ladder.model.Coin;

public class OddOnly implements Coin {
    private boolean isOdd = false;

    @Override
    public boolean toss() {
        return isOdd = !isOdd;
    }
}