package domain.ladder;

import domain.Direction;
import domain.Height;
import domain.Line;
import domain.PlayerNames;
import domain.Point;
import domain.ladder.strategy.GenerateBridgeStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final Height height;
    private final GenerateBridgeStrategy generateBridgeStrategy;

    public Ladder(List<Line> lines, Height height, GenerateBridgeStrategy generateBridgeStrategy) {
        this.lines = lines;
        this.height = height;
        this.generateBridgeStrategy = generateBridgeStrategy;
    }

    public static Ladder of(PlayerNames playerNames, Height height, GenerateBridgeStrategy generateBridgeStrategy) {
        List<Line> lines = new ArrayList<>();
        int numberOfLinesToMake = playerNames.getPlayerNames()
                .size();

        for (int index = 0; index < numberOfLinesToMake; index++) {
            lines.add(Line.fromHeight(height));
        }

        return new Ladder(lines, height, generateBridgeStrategy);
    }

    public void buildBridges() {
        for (int lineAt = 0; lineAt < lines.size() - 1; lineAt++) {
            Line startLine = lines.get(lineAt);
            Line endLine = lines.get(lineAt + 1);
            buildBridgesBetweenLine(startLine, endLine);
        }
    }

    private void buildBridgesBetweenLine(Line startLine, Line endLine) {
        List<Point> startLinePoints = startLine.getPoints();
        List<Point> endLinePoints = endLine.getPoints();

        for (int pointAt = 0; pointAt < height.getHeight(); pointAt++) {
            Point startPoint = startLinePoints.get(pointAt);
            Point endPoint = endLinePoints.get(pointAt);
            buildBridge(startPoint, endPoint);
        }
    }

    public void buildBridge(Point startPoint, Point endPoint) {
        if (isBuildable(startPoint, endPoint)) {
            startPoint.changeDirection(Direction.RIGHT_DOWN);
            endPoint.changeDirection(Direction.LEFT_DOWN);
        }
    }

    private boolean isBuildable(Point startPoint, Point endPoint) {
        return hasNotBridge(startPoint, endPoint)
                && generateBridgeStrategy.isGeneratedBridge();
    }

    private boolean hasNotBridge(Point startPoint, Point endPoint) {
        return startPoint.matchDirection(Direction.STRAIGHT_DOWN)
                && endPoint.matchDirection(Direction.STRAIGHT_DOWN);
    }

    public Point getPoint(int pointAt, int lineAt) {
        return this.lines.get(lineAt)
                .getPoints()
                .get(pointAt);
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public int getHeightSize() {
        return this.height.getHeight();
    }

}
