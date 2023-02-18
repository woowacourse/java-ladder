import java.util.ArrayList;
import java.util.List;

public class Line {
    private final TrueOrFalseGenerator trueOrFalseGenerator;
    private final List<Boolean> points;

    private static final int FIRST_INDEX = 0;
    private static final int INDEX_SIZE = 0;
    private static final int BEFORE_INDEX = 1;

    public Line(int personCount, TrueOrFalseGenerator trueOrFalseGenerator) {
        this.trueOrFalseGenerator = trueOrFalseGenerator;
        this.points = makeLine(personCount);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private List<Boolean> makeLine(int personCount) {
        List<Boolean> points = new ArrayList<>();
        for (int count = FIRST_INDEX; count < personCount-BEFORE_INDEX; count++) {
            points.add(correctOverLapPoints(points, trueOrFalseGenerator.generate(), count));
        }
        return points;
    }

    private Boolean correctOverLapPoints(List<Boolean> points, boolean current,int count) {
        if (points.size() == INDEX_SIZE) {
            return current;
        }
        if (!points.get(count-BEFORE_INDEX) || !current) {
            return current;
        }
        return false;
    }
}
