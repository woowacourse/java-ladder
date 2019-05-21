package ladder.domain;

public enum LadderRules {
    RIGHT(1),
    LEFT(-1),
    DRAW(1),
    SKIP(0),
    DRAW_MOVE(2),
    DRAW_SKIP(1);

    private int number;

    private LadderRules(int number) {
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    public boolean canDraw(int randomNumber) {
        return (this.number == randomNumber);
    }
}
