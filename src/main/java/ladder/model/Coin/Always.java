package ladder.model.Coin;

public class Always implements Coin {
    @Override
    public boolean toss() {
        return true;
    }
}