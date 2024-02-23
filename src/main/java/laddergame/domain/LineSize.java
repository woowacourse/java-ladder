package laddergame.domain;

public class LineSize {

    private final int lineSize;

    public LineSize(final Names names) {
        this.lineSize = names.getSize() - 1;
    }

    public boolean isBiggerThan(final int size) {
        return lineSize > size;
    }
}
