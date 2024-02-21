package domain.model;

import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static domain.model.Direction.LEFT;
import static domain.model.Direction.findDirection;

public class Line {

    private final List<Boolean> points;

    public Line(final int personCount) {
        points= new ArrayList<>(personCount);;
    }

    void draw(RandomGenerator generator, int personCount) {
        IntStream.range(0, personCount)
                .forEach(index -> makeHorizontalLine(generator, index));
    }

    private void makeHorizontalLine(RandomGenerator generator, int index) {
        points.add(false);
        if (generator.generate() >= 5 && !hasLeftConnectedLine(index)) {
            points.set(index, true);
        }
    }

    public boolean hasLeftConnectedLine(int index) {
        if (index == 0){
            return false;
        }
        return points.get(index -1);
    }
}
