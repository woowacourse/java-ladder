package domain;

import util.RandomValueGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount) {
        calculatePoints(personCount);
    }

    public List<Boolean> getPoints() {
        return points;
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

    // position = 0, point = 0
    // position = 1, point = 0, 1
    // position = 2, point = 1, 2
    // position = 3, point = 2, 3
    // position = 4, point = 3
    public String isRightLadder(int position, List<Boolean> points) {
        int lastPlayerPosition = points.size();
        int firstPlayerPosition = 0;

        if (position == firstPlayerPosition) {
            return getResultIsFirst(firstPlayerPosition, points);
        } if (position == lastPlayerPosition) {
            return getResultIsLast(lastPlayerPosition, points);
        } return getResultElse(position, points);
    }

    // player가 첫 번째 위치에 있을 때 0번째 point가 true면 무조건 right다.
    private String getResultIsFirst(int firstPlayerPosition, List<Boolean> points) {
        if (points.get(firstPlayerPosition)) {
            return "right";
        } return null;
    }

    // player가 마지막 위치에 있을 때 마지막 point가 true면 무조건 left다.
    private String getResultIsLast(int position, List<Boolean> points) {
        if (points.get(position - 1)) {
            return "left";
        } return null;
    }

    // player가 첫 번째 위치 또는 마지막 위치가 아니라면 현재 위치의 point와 그 전 위치의 point를 계산한다.
    private String getResultElse(int position, List<Boolean> points) {
        if (points.get(position - 1)) {
            return "left";
        } if (points.get(position)) {
            return "right";
        } return null;
    }
}
