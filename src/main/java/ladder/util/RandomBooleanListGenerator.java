package ladder.util;

import ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;

public class RandomBooleanListGenerator implements BooleanListGenerator {

    @Override
    public List<Point> generate(int size) {
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Point point = Point.getRandomPoint();
            list.add(point);
        }
        return list;
    }
}
