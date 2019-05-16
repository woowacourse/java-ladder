package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        points.add(RandomGenerator.getRandomBoolean());

        for (int i = 1; i < countOfPerson - 1; ++i) {
            points.add(generatePoints(points.get(i - 1)));
        }
    }

    public boolean generatePoints(boolean value) {
        return RandomGenerator.getRandomBoolean(value);
    }

    public List<Boolean> getPoints(){
        return this.points;
    }
}
