package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Line {
    private List<Point> points;

    public Line(int countOfPerson) {
        points = new ArrayList<>();
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(new Point(Boolean.FALSE));
        }
        makeRandomLink(countOfPerson);
    }

    public void makeRandomLink(int countOfPerson) {
        points.set(0, makeTrueOrFalse(generateRandomNumber()));
        for (int i = 1; i < countOfPerson - 1; i++) {
            setElement(i, makeTrueOrFalse(generateRandomNumber()));
        }
    }

    public void setElement(int index, Point point) {
        if (!points.get(index - 1).isTrue()) {
            points.set(index, point);
        }
    }

    public void printPoints() {
        points.stream().forEach(System.out::print);
    }

    public int generateRandomNumber() {
        return new Random().nextInt(2);
    }

    public Point isLinked(int point) {
        return points.get(point - 1);
    }

    public Point makeTrueOrFalse(int randomNumber) {
        return new Point(randomNumber != 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        for (Point point : points) {
            stringBuilder.append(point);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }
}
