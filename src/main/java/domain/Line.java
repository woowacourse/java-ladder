package domain;

import util.RandomValueGenerator;

import java.util.*;

public class Line {

    private static final String POINT_NUMBER_MESSAGE = "Point Number는 Points의 크기를 초과할 수 없습니다.";
    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount) {
        calculatePoints(personCount);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int getSize() {
        return points.size();
    }

    private void calculatePoints(int personCount) {
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
        points.add(randomValueGenerator.getRandomValue());
        while (personCount-- > 2) {
            if (!points.get(points.size() - 1)) {
                points.add(randomValueGenerator.getRandomValue());
                continue;
            }
            points.add(false);
        }
    }

    public boolean isRightMovable(int pointNumber) {
        if (pointNumber > points.size()) {
            throw new IllegalArgumentException(POINT_NUMBER_MESSAGE);
        }
        return points.get(pointNumber);
    }

    public boolean isLeftMovable(int playerPosition) {
        return points.get(playerPosition - 1);
    }
}
