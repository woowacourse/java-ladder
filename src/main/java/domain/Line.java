package domain;

import java.util.ArrayList;
import java.util.List;
import utils.LineMaker;

public class Line {

    private final LineMaker lineMaker;
    private final List<Boolean> points;

    public Line(LineMaker lineMaker, int userCount) {
        this.lineMaker = lineMaker;
        this.points = new ArrayList<>();
        addPoint(lineMaker.generateLine(userCount));
    }

    // TODO: 2023/02/15 메소드명 변경
    public void addPoint(List<Boolean> randomPoints) {
        for (Boolean randomPoint : randomPoints) {
            if (checkFront()) {
                points.add(false);
                continue;
            }
            points.add(randomPoint);
        }
    }

    private boolean checkFront() {
        return !points.isEmpty() && points.get(points.size() - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
