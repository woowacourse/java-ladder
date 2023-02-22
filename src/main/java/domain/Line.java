package domain;

import ui.output.LadderShape;
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
    // TODO: ELSE IF와 ELSE문을 쓰지 않기 위해서 메서드를 분리했는데, 메서드들이 대부분 비슷한 기능들을한다. 어떻게 해야 공통적인 특징을 줄일 수 있을까
    public String isRightLadder(int position, List<Boolean> points) {
        int lastPlayerPosition = points.size();
        // TODO: 매직넘버를 감싸기 위해 변수를 선언했다. 대신 메서드 길이가 늘었는데 매직넘버를 없애기 위한 괜찮은 접근인가
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
            return LadderShape.RIGHT.getShape();
        } return null;
    }

    // player가 마지막 위치에 있을 때 마지막 point가 true면 무조건 left다.
    private String getResultIsLast(int position, List<Boolean> points) {
        if (points.get(position - 1)) {
            return LadderShape.LEFT.getShape();
        } return null;
    }

    // player가 첫 번째 위치 또는 마지막 위치가 아니라면 현재 위치의 point와 그 전 위치의 point를 계산한다.
    private String getResultElse(int position, List<Boolean> points) {
        if (points.get(position - 1)) {
            return LadderShape.LEFT.getShape();
        } if (points.get(position)) {
            return LadderShape.RIGHT.getShape();
        } return null;
    }

}
