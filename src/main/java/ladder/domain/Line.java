package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private int lineLength;
    private List<Boolean> points = new ArrayList<>();
    public Line(int lineLength){
        this.lineLength = lineLength;
    }

    public int getLength() {
        return lineLength;
    }

}
