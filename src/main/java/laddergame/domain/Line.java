package laddergame.domain;

import laddergame.domain.rule.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> scaffolds;

    public Line(List<Boolean> scaffolds) {
        this.scaffolds = scaffolds;
    }

    public Line(int numberOfPlayer, Rule rule) {
        scaffolds = new ArrayList<>();
        for (int i = 0; i < numberOfPlayer + 1; i++) {
            scaffolds.add(false);
        }
        for (int i = 1; i < scaffolds.size() - 1; i++) {
            generateScaffold(i, rule);
        }
    }

    private void generateScaffold(int index, Rule rule) {
        if (canAddScaffold(index) && rule.canCreate()) {
            scaffolds.set(index, true);
        }
    }

    public Boolean canAddScaffold(int index) {
        return !(scaffolds.get(index + 1) || scaffolds.get(index - 1));
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
