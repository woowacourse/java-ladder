import java.util.ArrayList;
import java.util.List;

public class Line {
    private final TrueOrFalseGenerator trueOrFalseGenerator;
    private final List<Boolean> points;

    public Line(int personCount, TrueOrFalseGenerator trueOrFalseGenerator) {
        this.trueOrFalseGenerator = trueOrFalseGenerator;
        this.points = lineMaker(personCount);
    }

    private List<Boolean> lineMaker(int personCount) {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        for (int count = 1; count < personCount; count++) {
            points.add(correctOverLapPoints(points.get(count - 1), trueOrFalseGenerator.generate()));
        }
        points.remove(0);
        return points;
    }

    private Boolean correctOverLapPoints(boolean previous, boolean current) {
        if (!previous || !current) {
            return current;
        }
        return false;
    }

    private boolean changeIntToBoolean(int randomNumber) {
        if (randomNumber == Path.GO.getGoNumberValue()) {
            return Path.GO.getGoBooleanValue();
        }
        return Path.STOP.getGoBooleanValue();
    }

}
