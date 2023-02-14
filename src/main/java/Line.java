import java.util.ArrayList;
import java.util.List;

public class Line {
    RandomTrueAndFalseGenerator randomNumberGenerater = new RandomTrueAndFalseGenerator();
    private final List<Boolean> points;

    public Line(int personCount) {
        this.points = lineMaker(personCount);
    }

    public List<Boolean> lineMaker(int personCount) {
        List<Boolean> points = new ArrayList<>();
        for (int count = 1; count < personCount; count++) {

        }
        return points;
    }

    public boolean validate(Boolean previous, Boolean current) {
        if (!previous || !current) {
            return current;
        }
        return false;
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
