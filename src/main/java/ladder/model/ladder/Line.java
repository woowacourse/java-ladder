package ladder.model.ladder;

import ladder.model.player.Player;
import ladder.model.player.Players;

import java.util.stream.IntStream;

public class Line {
    private static final String EMPTY_LINE = "     ";
    private static final String FILLED_LINE = "-----";
    private static final String VERTICAL_LINE = "|";

    private Points points;

    public Line(Points points) {
        this.points = points;
    }

    private String getHorizontalLine(int pointIndex) {
        if (this.points.isTrue(pointIndex)) {
            return FILLED_LINE;
        }
        return EMPTY_LINE;
    }

    public void moveOneLine(Players players) {
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
