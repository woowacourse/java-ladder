package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    public static Ladder generateLadder(int width, Height height) {
        List<Line> lines = generateLines(width, height.getHeight());
        return new Ladder(lines);
    }

    private static List<Line> generateLines(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<Boolean> booleans = BooleanListGenerator.generateBoolList(width);
            List<Direction> directions = generateDirections(booleans);
            lines.add(generateLine(booleans, directions));
        }
        return lines;
    }

    private static Line generateLine(List<Boolean> booleans, List<Direction> directions) {
        return new Line(booleans, directions);
    }

    private static List<Direction> generateDirections(List<Boolean> booleans) {
        List<Direction> directions = new ArrayList<>();

        directions.add(Direction.first(booleans.get(0)));

        for (int i = 1; i < booleans.size(); i++) {
            directions.add(Direction.middle(booleans.get(i - 1), booleans.get(i)));
        }
        directions.add(Direction.last(booleans.get(booleans.size() - 1)));
        return directions;
    }
}
