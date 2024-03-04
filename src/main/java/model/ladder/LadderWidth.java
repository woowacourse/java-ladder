package model.ladder;

public class LadderWidth {

    private static final int LADDER_WIDTH_OFFSET = 1;

    private final int value;

    private LadderWidth(int value) {
        this.value = value;
    }

    public static LadderWidth from(int playersSize) {
        int width = playersSize - LADDER_WIDTH_OFFSET;
        return new LadderWidth(width);
    }

    public int getValue() {
        return value;
    }
}
