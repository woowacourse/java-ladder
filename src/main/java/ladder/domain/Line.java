package ladder.domain;

public class Line {

    private boolean isExist = false;

    public void make(LineSource lineSource) {

        if (lineSource == LineSource.MakeLine) {
            isExist = true;
        }
    }

    public boolean isExist() {
        return isExist;
    }
}
