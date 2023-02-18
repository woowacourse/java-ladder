package laddergame.view;

import laddergame.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

public enum LadderForm {
    LADDER_ROW_RUNG("-----"),
    LADDER_ROW_EMPTY("     "),
    LADDER_COL("|");

    private final String unit;

    LadderForm(String unit) {
        this.unit = unit;
    }

    public static String joinUnitsFrom(final List<String> names, final List<Line> lines) {
        return joinNames(names) + joinRows(lines);
    }

    private static String joinNames(final List<String> names) {
        String joined = names.stream().map(name -> String.format("%6s", name)).collect(Collectors.joining());
        return joined + System.lineSeparator();
    }

    private static String joinRows(final List<Line> lines) {
        final StringBuilder ladderBuilder = new StringBuilder();
        lines.forEach(line -> {
            ladderBuilder.append(LADDER_ROW_EMPTY.unit);
            ladderBuilder.append(LADDER_COL.unit);
            joinRowUnits(ladderBuilder, line);
            ladderBuilder.append(System.lineSeparator());
        });
        return ladderBuilder.toString();
    }

    private static void joinRowUnits(final StringBuilder ladderBuilder, final Line line) {
        line.getRungExistsAtColumn().forEach(rungExistsAtColumn -> {
            appendRowFilled(ladderBuilder, rungExistsAtColumn);
            appendRowEmpty(ladderBuilder, rungExistsAtColumn);
            ladderBuilder.append(LADDER_COL.unit);
        });
    }

    private static void appendRowEmpty(final StringBuilder ladderBuilder, final Boolean point) {
        if (point.equals(false)) {
            ladderBuilder.append(LADDER_ROW_EMPTY.unit);
        }
    }

    private static void appendRowFilled(StringBuilder ladderBuilder, Boolean point) {
        if (point.equals(true)) {
            ladderBuilder.append(LADDER_ROW_RUNG.unit);
        }
    }
}
