package ladder.domain;

public class PeopleCount {

    private final int peopleCount;
    private int currentCount;

    public PeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
        this.currentCount = 0;
    }

    public void counting() {
        this.currentCount++;
    }

    public boolean isEnd() {
        return peopleCount == currentCount;
    }
}
