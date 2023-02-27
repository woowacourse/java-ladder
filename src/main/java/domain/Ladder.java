package domain;

public class Ladder {

    private final Lines ladder;
    private final Height height;

    public Ladder(Lines ladder, Height height) {
        this.ladder = ladder;
        this.height = height;
    }

    public Lines getLadder() {
        return this.ladder;
    }
}
