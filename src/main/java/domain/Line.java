package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    List<Boolean> points;

    public Line() {
    }

    public Line(int personCount) {
        points = new ArrayList<>(personCount - 1);
    }
}
