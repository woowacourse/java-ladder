package ladder.domain;

public class Line {

    private boolean isExist;

    public void make(Boolean value) {
        isExist = value;
    }

    public boolean isExist() {
        return isExist;
    }
}
