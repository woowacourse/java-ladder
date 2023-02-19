package laddergame.view;

import laddergame.domain.Line;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public enum LadderForm {
    LADDER_ROW_FILLED("-"),
    LADDER_ROW_EMPTY(" "),
    LADDER_COL("|");

    private static final String NAMES_EMPTY_EXCEPTION = "이름 목록은 비어있을 수 없습니다.";
    private static final String NAME_BLANK_FILL_FORM = "%{0}s";

    private final String unit;

    LadderForm(final String unit) {
        this.unit = unit;
    }

    public static String joinUnitsFrom(final List<String> names, final List<Line> lines) {
        int maxNameLength = findMaxNameLength(names);
        return joinNames(names, maxNameLength) + joinRows(lines, maxNameLength);
    }

    private static String joinNames(final List<String> names, final int maxNameLength) {
        final String nameForm = MessageFormat.format(NAME_BLANK_FILL_FORM, maxNameLength + 1);
        final String joined = names.stream()
                .map(name -> String.format(nameForm, name))
                .collect(Collectors.joining());
        return joined + System.lineSeparator();
    }

    private static String joinRows(final List<Line> lines, final int maxNameLength) {
        final StringBuilder ladderBuilder = new StringBuilder();
        lines.forEach(line -> {
            ladderBuilder.append(LADDER_ROW_EMPTY.unit.repeat(maxNameLength));
            ladderBuilder.append(LADDER_COL.unit);
            joinRowUnits(ladderBuilder, line, maxNameLength);
            ladderBuilder.append(System.lineSeparator());
        });
        return ladderBuilder.toString();
    }

    private static void joinRowUnits(final StringBuilder ladderBuilder,
                                     final Line line,
                                     final int maxNameLength
    ) {
        line.getPoints().forEach(point -> {
            appendRowFilled(ladderBuilder, point, maxNameLength);
            appendRowEmpty(ladderBuilder, point, maxNameLength);
            ladderBuilder.append(LADDER_COL.unit);
        });
    }

    private static void appendRowEmpty(final StringBuilder ladderBuilder,
                                       final boolean isRowFilled,
                                       final int maxNameLength
    ) {
        if (!isRowFilled) {
            ladderBuilder.append(LADDER_ROW_EMPTY.unit.repeat(maxNameLength));
        }
    }

    private static void appendRowFilled(final StringBuilder ladderBuilder,
                                        final boolean isRowFilled,
                                        final int maxNameLength
    ) {
        if (isRowFilled) {
            ladderBuilder.append(LADDER_ROW_FILLED.unit.repeat(maxNameLength));
        }
    }

    private static int findMaxNameLength(final List<String> names) {
        return names.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(NAMES_EMPTY_EXCEPTION));
    }
}
