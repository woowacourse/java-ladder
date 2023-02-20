package ladder.domain;

public class Line {

    private boolean isExist = false;

    public void make(LineSource lineSource) {
        if (lineSource == LineSource.MAKE_LINE) {
            isExist = true;
        }
    }

    public boolean isExist() {
        return isExist;
    }

    public boolean notExist() {
        return !isExist;
    }
}
