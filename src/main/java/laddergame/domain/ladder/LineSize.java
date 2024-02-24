package laddergame.domain.ladder;

import laddergame.domain.name.Names;

public class LineSize {

    private final int lineSize;

    public LineSize(final Names names) {
        this.lineSize = names.getSize() - 1;
    }

    public boolean isBiggerThan(final int size) {
        return lineSize > size;
    }
}
