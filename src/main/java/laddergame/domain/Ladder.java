package laddergame.domain;

import static laddergame.utils.OptionalUtils.getValueAfterNullCheck;

public class Ladder {
    private final Lines lines;

    public Ladder(final Lines inputLines) {
        this.lines = getValueAfterNullCheck(inputLines);
    }

    public Position findLastDestination(final Position row) {
        final Height height = lines.getHeight();
        Position participantRow = row;
        for (int column = 0; column < height.getValue(); column++) {
            final Position currentColumn = new Position(column);
            participantRow = findNextPosition(currentColumn, participantRow);
        }
        return participantRow;
    }

    public Lines getLines() {
        return lines;
    }

    private Position findNextPosition(final Position column, final Position row) {
        final Width width = lines.getLines().get(column.getValue()).getWidth();
        final Position maxPosition = new Position(width.getValue());
        final Position leftPosition = row.move(-1);
        final Position rightPosition = row.move(0);

        if (leftPosition.checkBetweenZeroAnd(maxPosition) && lines.getPointByColumnAndRow(column, leftPosition)) {
            return row.move(-1);
        }
        if (rightPosition.checkBetweenZeroAnd(maxPosition) && lines.getPointByColumnAndRow(column, rightPosition)) {
            return row.move(1);
        }
        return row;
    }
}
