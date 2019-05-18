package ladder.domain;

public enum LadderRules {
    RIGHT(1),
    LEFT(-1),
    SKIP(0);

    private int number;

    private LadderRules(int number) {
        this.number = number;
    }

    public int number() {
        return this.number;
    }
}
