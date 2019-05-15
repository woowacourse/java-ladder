package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Line {
    private List<Boolean> points;

    public Line(int countOfPerson) {
        points = new ArrayList<>();
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(Boolean.FALSE);
        }
        makeRandomLink(countOfPerson);
    }

    public void makeRandomLink(int countOfPerson) {
        points.set(0, makeTrueOrFalse(generateRandomNumber()));
        for (int i = 1; i < countOfPerson - 1; i++) {
            setElement(i, makeTrueOrFalse(generateRandomNumber()));
        }
    }

    public void setElement(int index, boolean trueOrFalse){
        if (!points.get(index - 1)) {
            points.set(index, trueOrFalse);
        }
    }

    public void printPoints() {
        points.stream().forEach(System.out::print);
    }

    public int generateRandomNumber() {
        return new Random().nextInt(2);
    }

    public boolean isLinked(int point) {
        return points.get(point - 1);
    }

    public boolean makeTrueOrFalse(int randomNumber) {
        return randomNumber != 0;
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
}
