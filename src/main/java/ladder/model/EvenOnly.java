package ladder.model;

public class EvenOnly implements Possible {
    private boolean isEven = true;

    @Override
    public boolean isPossible() {
        return isEven = !isEven;
    }
}