package ladder.model.coin;

public class Always implements Coin {
    @Override
    public boolean toss() {
        return true;
    }
}