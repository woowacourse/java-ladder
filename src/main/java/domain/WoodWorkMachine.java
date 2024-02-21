package domain;

import java.util.ArrayList;
import java.util.List;

public class WoodWorkMachine {
    private static final Point EXIST_POINT = new Point(Step.EXIST);
    private static final Point EMPTY_POINT = new Point(Step.EMPTY);

    private final NumberGenerator randomNumberGenerator;
    private final PlayerCount playerCount;

    public WoodWorkMachine(final PlayerCount playerCount) {
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.playerCount = playerCount;
    }

    public Line makeLine() {
        List<Point> points = new ArrayList<>();

        addFirstPoint(points); // TODO: 갖고 들어가지 않는 방식으로 수정
        addMiddlePoint(points);
        addLastPoint(points);

        return new Line(points);
    }

    private void addFirstPoint(List<Point> points) {
        points.add(generate());
    }

    private void addMiddlePoint(List<Point> points) {
        int buildCount = 1;
        while (isInCountRange(buildCount)) {
            points.add(getPoint(points, buildCount));
            buildCount++;
        }
    }

    private boolean isInCountRange(int buildCount) { // 사다리 최대 높이보다 적으면서, 마지막 인덱스 - 1까지
        return playerCount.isBiggerThan(buildCount + 1); // TODO: 연산 방식 수정
    }

    private void addLastPoint(List<Point> points) {
        points.add(new Point(Step.EMPTY));
    }

    private Point generate() {
        if (canBuild()) {
            return new Point(Step.EXIST);
        }
        return new Point(Step.EMPTY);
    }

    private boolean canBuild() { // TODO: 랜덤 작업이 이루어지는 곳이 목공기계, 랜덤 재료는 컨트롤러-목수한테 받아옴 -> 1. 만약 기계가 필드로 랜덤 갖고 있고 point한테 넣어준다면?
        if (randomNumberGenerator.generate() == 0) {
            return false;
        }
        return true;
    }

    private Point getPoint(List<Point> points, int index) {
        if (points.get(index -1).equals(EXIST_POINT)) {
            return EMPTY_POINT;
        }
        return generate();
    }
}
