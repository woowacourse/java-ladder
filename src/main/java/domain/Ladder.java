package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import util.RandomNumberGenerator;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(PlayerNumber playerNumber, Height height) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, playerNumber.getLineNumber())
                .forEach(it -> lines.add(Line.fromHeight(height)));

        return new Ladder(lines);
    }

    public void shuffleLadder() {
        for (int i = 0; i < lines.size() - 1; i++) {
            for (int j = 0; j < lines.get(i).getPoints().size(); j++) {
                // 여기서, 난수 발생
                if (isBuildable()) {
                    buildBridge(j, i);
                }
            }
        }
    }

    public void buildBridge(int y, int x) {
        Point startPoint = lines.get(x).getPoints().get(y);
        Point endPoint = lines.get(x + 1).getPoints().get(y);

        if (hasNotBridge(startPoint, endPoint)) {
            startPoint.changeDirection(Direction.RIGHT_DOWN);
            endPoint.changeDirection(Direction.LEFT_DOWN);
        }
    }

    private boolean hasNotBridge(Point startPoint, Point endPoint) {
        return startPoint.matchDirection(Direction.STRAIGHT_DOWN)
                && endPoint.matchDirection(Direction.STRAIGHT_DOWN);
    }

    public boolean isBuildable() {
        return 8 <= RandomNumberGenerator.pickRandomNumberInRange(1, 10);
    }

    public Point getPoint(int y, int x) {
        return lines.get(x).getPoints().get(y);
    }

    public List<Line> getLines() {
        return lines;
    }
}
