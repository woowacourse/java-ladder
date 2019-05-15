package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private Random random = new Random();

    public Line(int countOfPerson) {
        points.add(random.nextBoolean());

        for (int i = 1; i < countOfPerson - 1; ++i) {
            points.add(generatePoints(points.get(i - 1)));
        }
    }

    public boolean generatePoints(boolean value) {
        return (value == true)? false : random.nextBoolean();
    }

    public List<Boolean> getPoints(){
        return this.points;
    }
}
