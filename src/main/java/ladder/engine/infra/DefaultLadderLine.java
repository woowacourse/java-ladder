package ladder.engine.infra;

import ladder.engine.LadderLine;

import java.util.List;

class DefaultLadderLine implements LadderLine {
    private final List<Point> points;

    DefaultLadderLine(List<Point> points) {
        this.points = points;
    }

    @Override
    public int move(int position) {
        return points.get(position).move();
    }

    @Override
    public String toString() {
        return "DefaultLadderLine{" +
                "points=" + points +
                '}';
    }
}

