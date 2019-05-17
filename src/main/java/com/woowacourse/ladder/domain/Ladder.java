package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public List<Point> createPoints(List<Boolean> booleans) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i <= booleans.size() ; i++) {
            points.add(new Point(i, 1000));
        }
        return points;
    }

    public List<Direction> createDirections(List<Boolean> booleans) {
        List<Direction> directions = new ArrayList<>();

        for (int i = 0; i < booleans.size() - 1; i++) {
            if (i == 0) {
                directions.add(Direction.first(booleans.get(i)));
            }
            directions.add(Direction.middle(booleans.get(i), booleans.get(i + 1)));
        }
        directions.add(Direction.last(booleans.get(booleans.size() - 1)));
        return directions;
    }
}

