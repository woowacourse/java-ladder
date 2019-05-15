package ladder.model;

public class Never implements Possible {
    @Override
    public boolean isPossible() {
        return false;
    }
}
