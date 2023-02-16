package laddergame;

import laddergame.domain.Line;

import java.util.List;

public enum LadderForm {
    LADDER_ROW_FILLED("-----"),
    LADDER_ROW_EMPTY("     "),
    LADDER_COL("|");

    private final String unit;

    LadderForm(String unit) {
        this.unit = unit;
    }

    public static String joinUnitsFrom(final List<Line> lines) {
        return joinRows(lines);
    }

    private static String joinRows(List<Line> lines) {
        final StringBuilder ladderBuilder = new StringBuilder();
        lines.forEach(line -> {
            ladderBuilder.append(LADDER_COL.unit);
            joinRowUnits(ladderBuilder, line);
            ladderBuilder.append(System.lineSeparator());
        });
        return ladderBuilder.toString();
    }

    private static void joinRowUnits(StringBuilder ladderBuilder, Line line) {
        line.getPoints().forEach(point -> {
            appendRowFilled(ladderBuilder, point);
            appendRowEmpty(ladderBuilder, point);
            ladderBuilder.append(LADDER_COL.unit);
        });
    }

    private static void appendRowEmpty(StringBuilder ladderBuilder, Boolean point) {
        if (point.equals(false)) {
            ladderBuilder.append(LADDER_ROW_EMPTY.unit);
        }
    }

    private static void appendRowFilled(StringBuilder ladderBuilder, Boolean point) {
        if (point.equals(true)) {
            ladderBuilder.append(LADDER_ROW_FILLED.unit);
        }
    }
}
