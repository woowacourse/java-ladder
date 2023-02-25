package ladder.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    CENTER(0);

    private final int indexDifference;

    Direction(int indexDifference) {
        this.indexDifference = indexDifference;
    }

    public int getIndexDifference() {
        return indexDifference;
    }
}
