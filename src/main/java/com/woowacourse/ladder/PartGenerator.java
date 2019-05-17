package com.woowacourse.ladder;

import javafx.beans.binding.BooleanBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PartGenerator {

    PartGenerator() {

    }

    public static List<Point> generatePoints(List<Boolean> booleans) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i <= booleans.size(); i++) {
            points.add(new Point(i, 1000));
        }
        return points;
    }

    public static List<Direction> generateDirections(List<Boolean> booleans) {
        List<Direction> directions = new ArrayList<>();

        directions.add(Direction.first(booleans.get(0)));

        for (int i = 1; i < booleans.size(); i++) {
            directions.add(Direction.middle(booleans.get(i - 1), booleans.get(i)));
        }
        directions.add(Direction.last(booleans.get(booleans.size() - 1)));
        return directions;
    }

    public static Point generatePoint(int order) {
        return new Point(order, 1000);
    }

    public static Ladder generateLadder(int width, int height, HashMap<Integer, List<Boolean>> map) {
        List<Line> lines = generateLines(width, height, map);
        return new Ladder(lines, width);
    }

    private static List<Line> generateLines(int width, int height, HashMap<Integer, List<Boolean>> map) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            //List<Boolean> booleans = PartGenerator.generateBoolList(width);
            List<Boolean> booleans = map.get(i);
            List<Point> points = PartGenerator.generatePoints(booleans);
            List<Direction> directions = PartGenerator.generateDirections(booleans);
            lines.add(PartGenerator.generateLine(booleans, points, directions));
        }
        return lines;
    }

    public static Line generateLine(List<Boolean> booleans, List<Point> points, List<Direction> directions) {
        return new Line(booleans, points, directions);
    }

    public static List<Boolean> generateBoolList(int nameLength) {
        List<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < nameLength - 1; i++) {
            addBoolean(booleans, i);
        }
        return booleans;
    }

    public static List<Boolean> generateBoolList2(List<Boolean> testBooleanList) {
        return testBooleanList;
    }


    private static void addBoolean(List<Boolean> booleans, int i) {
        if (i == 0) {
            booleans.add(true);
            return;
        }
        if (!booleans.get(i - 1)) {
            booleans.add(true);
            return;
        }
        booleans.add(false);
    }


}
