package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PointGenerator {

    PointGenerator(List<Boolean> booleans) {
        List<Point> points = new ArrayList<>();
        List<Direction> directions = new ArrayList<>();
        for (int i = 0; i < booleans.size() - 1; i++) {
            points.add(new Point(i, 1000));
            if (i == 0) {
                directions.add(Direction.first(booleans.get(i)));
            }
            directions.add(Direction.middle(booleans.get(i),booleans.get(i+1)));
        }
        directions.add(Direction.last(booleans.get(booleans.size()-1)));
    }
}
