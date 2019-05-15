package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> scaffolds;

    public Line() {
        scaffolds = new ArrayList<>();
    }

    public Line(List<Boolean> scaffolds) {
        this.scaffolds = scaffolds;
    }

    public Boolean canAddTrueScaffold() {
        return (scaffolds.isEmpty()) || (!scaffolds.get(scaffolds.size() - 1));
    }

    public Boolean addScaffold(boolean scaffold) {
        return scaffolds.add(scaffold);
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

    @Override
    public String toString() {
        return "Line{" +
                "scaffolds=" + scaffolds +
                '}';
    }
}
