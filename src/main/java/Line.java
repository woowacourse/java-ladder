import java.util.ArrayList;
import java.util.List;

public class Line {
    RandomNumberGenerater randomNumberGenerater = new RandomNumberGenerater();
    private final List<Boolean> points;

    public Line(int personCount) {
        this.points = lineMaker(personCount);
    }

    public List<Boolean> lineMaker(int personCount) {
        List<Boolean> points = new ArrayList<>();
        for (int count = 0; count < personCount-1; count++) {
            points.add(changeNumberToBoolean(randomNumberGenerater.generate()));
        }
        return points;
    }

    private boolean changeNumberToBoolean(int randomNumber) {
        return randomNumber != 0;
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
