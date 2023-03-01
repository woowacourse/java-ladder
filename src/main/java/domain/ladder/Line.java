package domain.ladder;

import domain.player.Player;
import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<LinePoint> points;

    public Line(List<LinePoint> points) {
        this.points = new ArrayList<>(points);
    }

    public void move(Player player) {
        LinePoint findPoint = points.stream()
                .filter(point -> player.isSamePosition(point.getPosition()))
                .findFirst()
                .orElseThrow();

        player.move(findPoint.getDirectionValue());
    }

    public List<LinePoint> getPoints() {
        return points;
    }
}
