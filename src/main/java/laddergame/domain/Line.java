package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> scaffolds;

    public Line(List<Boolean> scaffolds) {
        this.scaffolds = scaffolds;
    }

    public Line(int numberOfPerson) {
        List<Boolean> scaffolds = new ArrayList<>();
        for (int i = 0; i < numberOfPerson + 1; i++) {
            scaffolds.add(false);
        }
        this.scaffolds = scaffolds;
    }

    public Boolean canAddScaffold(int index) {
        return !(scaffolds.get(index + 1) || scaffolds.get(index - 1));
    }

    public void addScaffold(int index) {
        scaffolds.set(index, true);
    }

    public List<Boolean> getScaffolds() {
        return scaffolds;
    }

    public int moveNextPoint(int point) {
        if (outOfPointRange(point)) {
            throw new IllegalArgumentException("이동 범위를 벗어났습니다.");
        }
        if (scaffolds.get(point)) {
            return point - 1;
        }
        if (scaffolds.get(point + 1)) {
            return point + 1;
        }
        return point;
    }

    private boolean outOfPointRange(int point) {
        return (point < 0) || (point > scaffolds.size() - 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(scaffolds, line.scaffolds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scaffolds);
    }
}
