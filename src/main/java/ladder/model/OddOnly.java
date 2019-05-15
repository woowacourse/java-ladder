package ladder.model;

public class OddOnly implements Possible {
    private boolean isOdd = false;

    @Override
    public boolean isPossible() {
        return isOdd = !isOdd;
    }
}