package laddergame.domain;

public class LadderWidth {

    private final int width;

    private LadderWidth(final Names names) {
        this.width = calculateWidth(names);
    }

    public static LadderWidth from(final Names names) {
        return new LadderWidth(names);
    }

    private int calculateWidth(final Names names) {
        final int maxLengthSkipFirst = names.getMaxLengthSkipFirst();
        final int lastLength = names.getLastLength();

        if (maxLengthSkipFirst == lastLength) {
            return lastLength + 1;
        }

        return maxLengthSkipFirst;
    }

    public int getWidth() {
        return width;
    }
}
