package ladder.domain;

import java.util.List;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int getMovedIndex(int index) {
        return index + points.get(index).move();
    }

    public boolean isConnectedToRight(int index) {
        return points.get(index).isConnectedToRight();
    }

    public int getNumberOfPlayers() {
        return points.size();
    }
}
