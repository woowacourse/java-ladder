package ladder.model;

import java.util.stream.IntStream;

public class Line {
    private static final String EMPTY_LINE = "     ";
    private static final String FILLED_LINE = "-----";
    private static final String VERTICAL_LINE = "|";

    private Points points;

    public Line(Points points) {
        checkPointsValid(points);
        this.points = points;
    }

    public void checkPointsValid(Points points) {
        int length = points.size();
        IntStream.range(1, length).forEach(i -> checkContinued(points, i - 1));
    }

    private void checkContinued(Points points, int index) {
        if (points.isTrue(index) && points.isTrue(index + 1)) {
            throw new IllegalArgumentException("이어지는 가로라인 발생");
        }
    }

    private String getHorizontalLine(int pointIndex) {
        if (this.points.isTrue(pointIndex)) {
            return FILLED_LINE;
        }
        return EMPTY_LINE;
    }

    void moveOneLine(Players players) {
        players.forEach(player -> move(player));
    }

    public void move(Player player) {
        int position = player.getPosition();
        if (position > 0 && points.isTrue(position - 1)) {
            player.moveLeft();
        }
        if (points.isUnderLast(position) && points.isTrue(position)) {
            player.moveRight();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(VERTICAL_LINE);
        int length = points.size();
        IntStream.range(0, length).forEach(i -> stringBuilder.append(getHorizontalLine(i)).append(VERTICAL_LINE));

        return stringBuilder.toString();
    }
}
