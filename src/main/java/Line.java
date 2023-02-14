import java.util.ArrayList;
import java.util.List;

public class Line {
    private final TrueAndFalseGenerator trueAndFalseGenerator;
    private final List<Boolean> points;

    public Line(int personCount, TrueAndFalseGenerator trueAndFalseGenerator) {
        this.trueAndFalseGenerator = trueAndFalseGenerator;
        this.points = lineMaker(personCount);
    }

    private List<Boolean> lineMaker(int personCount) {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        for (int count = 1; count < personCount; count++) {
            points.add(validate(points.get(count - 1), trueAndFalseGenerator.generate()));
        }
        return points;
    }

    private boolean validate(Boolean previous, Boolean current) {
        if (!previous || !current) {
            return current;
        }
        return false;
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
