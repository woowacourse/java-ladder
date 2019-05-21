package ladder.model.coin;

public class EvenOnly implements Coin {
    private boolean isEven = true;

    @Override
    public boolean toss() {
        return isEven = !isEven;
    }
}