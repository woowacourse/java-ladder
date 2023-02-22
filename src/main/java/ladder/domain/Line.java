package ladder.domain;

public class Line {

    private boolean isExist = false;

    public void make(LineSource lineSource) {
        if (lineSource == LineSource.MAKE_LINE) {
            isExist = true;
            return;
        }
        if (lineSource == LineSource.MAKE_BLANK) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    public boolean isExist() {
        return isExist;
    }

    public boolean notExist() {
        return !isExist;
    }
}
