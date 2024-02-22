package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }
    public static Line createByStrategy(final PointGenerator pointGenerator, final int personCount) {
        List<Boolean> points = new ArrayList<>();
        while (points.size() != personCount - 1) {
            final boolean pointCandidate = pointGenerator.generate();
            final boolean previousPoint = findPreviousPoint(points);

            points.add(createPoint(pointCandidate, previousPoint));
        }
        return new Line(points);
    }

    private static boolean findPreviousPoint(List<Boolean> points) {
        if (points.size() == 0) {
            return false;
        }
        return points.get(points.size() - 1);
    }

    private static boolean createPoint(final boolean pointCandidate, final boolean previousPoint) {
        if (!pointCandidate) {
            return pointCandidate;
        }
        if (previousPoint == false) {
            return pointCandidate;
        }
        return false;
    }


    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
