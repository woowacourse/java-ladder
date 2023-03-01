package ladder.domain;

public class Line {
    private boolean isExist = false;

    public void make(LineSource lineSource) {
        isExist = lineSource.makeLine();
    }

    public boolean isExist() {
        return isExist;
    }

    public boolean notExist() {
        return !isExist;
    }
}
