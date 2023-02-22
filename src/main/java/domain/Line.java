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

    public String isRightLadder(int position, List<Boolean> points) {
        // points = [ 0   , 1    , 2   , 3     ]
        // points = [ true, false, true, false ]

        // position = 0, point = 0
        // position = 1, point = 0, 1
        // position = 2, point = 1, 2
        // position = 3, point = 2, 3
        // position = 4, point = 3
        int lastPlayerPosition = points.size();
        int firstPlayerPosition = 0;

        // player가 0번째 위치에 있을 때 0번째 point가 true면 무조건 right다.
        if (position == firstPlayerPosition) {
            if (points.get(firstPlayerPosition)) {
                return "right";
            } return "none";
            // player가 마지막 위치에 있을 때 마지막 point가 true면 무조건 left다.
        } else if (position == lastPlayerPosition) {
            if (points.get(position - 1)) {
                return "left";
            } return "none";
        } else {
            if (points.get(position - 1)) {
                return "left";
            } else if (points.get(position)) {
                return "right";
            } return "none";
        }
    }
}
