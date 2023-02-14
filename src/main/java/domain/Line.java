package domain;

import java.util.List;

public class Line {
    List<Boolean> existedLine;

    public Line(List<Boolean> existedLine) {
        this.existedLine = existedLine;
    }

    public List<Boolean> getExistedLine() {
        return existedLine;
    }
}
