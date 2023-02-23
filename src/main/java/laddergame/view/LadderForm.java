package laddergame.view;

import laddergame.domain.GameResults;
import laddergame.domain.Line;
import laddergame.domain.Lines;
import laddergame.domain.Names;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public enum LadderForm {
    LADDER_ROW_FILLED("-"),
    LADDER_ROW_EMPTY(" "),
    LADDER_COL("|");

    private static final String NAME_BLANK_FILL_FORM = "%{0}s";

    private final String unit;

    LadderForm(final String unit) {
        this.unit = unit;
    }

    public static String joinUnitsFrom(final Names names, final Lines lines, final GameResults results) {
        final int maxNameLength = Math.max(names.getMaxNameLength(), results.getMaxResultLength());
        return joinValues(names.getNameValues(), maxNameLength)
                + joinRows(lines, maxNameLength)
                + joinValues(results.getResultValues(), maxNameLength);
    }

    private static String joinValues(final List<String> values, final int maxLength) {
        final String nameForm = MessageFormat.format(NAME_BLANK_FILL_FORM, maxLength + 1);
        final String joined = values.stream()
                .map(name -> String.format(nameForm, name))
                .collect(Collectors.joining());
        return joined + System.lineSeparator();
    }

    private static String joinRows(final Lines lines, final int maxLength) {
        final StringBuilder ladderBuilder = new StringBuilder();
        lines.getLines().forEach(line -> {
            ladderBuilder.append(LADDER_ROW_EMPTY.unit.repeat(maxLength));
            ladderBuilder.append(LADDER_COL.unit);
            joinRowUnits(ladderBuilder, line, maxLength);
            ladderBuilder.append(System.lineSeparator());
        });
        return ladderBuilder.toString();
    }

    private static void joinRowUnits(final StringBuilder ladderBuilder,
                                     final Line line,
                                     final int maxLength
    ) {
        line.getPoints().forEach(point -> {
            appendRowFilled(ladderBuilder, point, maxLength);
            appendRowEmpty(ladderBuilder, point, maxLength);
            ladderBuilder.append(LADDER_COL.unit);
        });
    }

    private static void appendRowEmpty(final StringBuilder ladderBuilder,
                                       final boolean isRowFilled,
                                       final int maxLength
    ) {
        if (!isRowFilled) {
            ladderBuilder.append(LADDER_ROW_EMPTY.unit.repeat(maxLength));
        }
    }

    private static void appendRowFilled(final StringBuilder ladderBuilder,
                                        final boolean isRowFilled,
                                        final int maxLength
    ) {
        if (isRowFilled) {
            ladderBuilder.append(LADDER_ROW_FILLED.unit.repeat(maxLength));
        }
    }
}
