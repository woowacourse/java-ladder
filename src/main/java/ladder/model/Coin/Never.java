package ladder.model.Coin;

public class Never implements Coin {
    @Override
    public boolean toss() {
        return false;
    }
}
