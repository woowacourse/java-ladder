package domain;

import java.util.List;
import utils.NumberMaker;

public class Line {

    private final NumberMaker numberMaker;
    private final List<Boolean> points;

    public Line(NumberMaker numberMaker, List<Boolean> points) {
        this.numberMaker = numberMaker;
        this.points = points;
    }

    // TODO: 2023/02/15 메소드명 변경
    public void addPoint(int bound) {
        if (checkFront()) {
            points.add(false);
            return;
        }
        points.add(numberMaker.generateNumber(bound));
    }

    private boolean checkFront() {
        return !points.isEmpty() && points.get(points.size() - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
