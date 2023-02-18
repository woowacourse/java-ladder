package laddergame.view;

import laddergame.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

import static laddergame.view.LadderUnit.*;

public class LadderFormGenerator {
    public static String generate(final List<String> names, final List<Line> lines) {
        return joinNames(names) + joinRows(lines);
    }

    private static String joinNames(final List<String> names) {
        String joined = names.stream().map(name -> String.format("%6s", name)).collect(Collectors.joining());
        return joined + System.lineSeparator();
    }

    private static String joinRows(final List<Line> lines) {
        final StringBuilder ladderBuilder = new StringBuilder();
        lines.forEach(line -> {
            ladderBuilder.append(LADDER_ROW_EMPTY.getDisplayUnit() + LADDER_COL.getDisplayUnit());

            joinUnitsOfRowFrom(line.getRungExistsAtEachColumn(), ladderBuilder);

            ladderBuilder.append(System.lineSeparator());
        });
        return ladderBuilder.toString();
    }

    private static void joinUnitsOfRowFrom(final List<Boolean> rungExistsAtEachColumn, final StringBuilder ladderBuilder) {
        rungExistsAtEachColumn.forEach(rungExists -> {
            ladderBuilder.append(getRowDisplayUnitOf(rungExists));
            ladderBuilder.append(LADDER_COL.getDisplayUnit());
        });
    }

    private static String getRowDisplayUnitOf(boolean rungExistsAtColumn) {
        if (rungExistsAtColumn) {
            return LADDER_ROW_RUNG.getDisplayUnit();
        }
        return LADDER_ROW_EMPTY.getDisplayUnit();
    }
}
