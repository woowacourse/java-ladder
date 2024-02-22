package domain.model;

import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    public Line(RandomGenerator randomGenerator, final int personCount) {
        points = new ArrayList<>(personCount);
        draw(randomGenerator, personCount);
    }

    public List<Integer> findHorizontal() {
        return IntStream.range(0, points.size())
                .sequential()
                .filter(points::get)
                .boxed()
                .toList();
    }

    void draw(RandomGenerator generator, int personCount) {
        IntStream.range(0, personCount - 1)
                .forEach(index -> makeHorizontalLine(generator, index));

    }

    private void makeHorizontalLine(RandomGenerator generator, int index) {
        points.add(false);
        if (generator.generate() >= 5 && !hasLeftConnectedLine(index)) {
            points.set(index, true);
        }
    }

    public boolean hasLeftConnectedLine(int index) {
        if (index == 0) {
            return false;
        }
        return points.get(index - 1);
    }

    public Direction showDirection(int index){
        if (points.get(index)){
            return Direction.RIGHT;
        }
        if (index > 0 && points.get(index-1)){
            return Direction.LEFT;
        }
        return Direction.NONE;
    }

}
