package domain;

import java.util.ArrayList;
import java.util.List;

public class WoodWorkMachine {
    private final NumberGenerator randomNumberGenerator;
    private final PlayerCount playerCount;

    public WoodWorkMachine(NumberGenerator randomNumberGenerator, PlayerCount playerCount) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.playerCount = playerCount;
    }

    private boolean canBuild() {
        if (randomNumberGenerator.generate() == 0) {
            return false;
        }
        return true;
    }

    private Point generate() {
       if (canBuild()) {
           return new Point(Step.EXIST);
       }
       return new Point(Step.EMPTY);
    }

    public Line makeLine() {
        List<Point> points = new ArrayList<>();

        addFirstPoint(points);
        addMiddlePoint(points);
        addLastPoint(points);

        return new Line(points);
    }

    private void addLastPoint(List<Point> points) {
        points.add(new Point(Step.EMPTY));
    }

    private void addMiddlePoint(List<Point> points) {
        Point truePoint = new Point(Step.EXIST);
        Point falsePoint = new Point(Step.EMPTY);

        int buildCount = 1;
        while (playerCount.isBiggerThan(buildCount + 1)) { // TODO: 연산 방식 수정
            addOnExistPoint(points, buildCount, truePoint, falsePoint); // todo: 중복 제거
            addOnEmptyPoint(points, buildCount, falsePoint);
            buildCount++;
        }
    }

    private void addOnEmptyPoint(List<Point> points, int i, Point falsePoint) {
        if (points.get(i -1).equals(falsePoint)) {
            points.add(generate());
        }
    }

    private static void addOnExistPoint(List<Point> points, int i, Point truePoint, Point falsePoint) {
        if (points.get(i -1).equals(truePoint)) {
            points.add(falsePoint);
        }
    }

    private void addFirstPoint(List<Point> points) {
        points.add(generate());
    }
}
