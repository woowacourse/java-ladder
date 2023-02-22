package type;

public enum LadderElementInformation {
    MIN_LENGTH(1),
    MAX_LENGTH(5);
    private final int length;

    LadderElementInformation(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
