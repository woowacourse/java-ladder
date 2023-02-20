package laddergame.view;

import laddergame.domain.Line;
import laddergame.domain.Participants;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import static laddergame.view.LadderUnit.*;

public class LadderFormGenerator {
    private int rungLength;

    public String generate(final Participants participants, final List<Line> lines) {
        rungLength = getMaximumLengthOfNames(participants.getNames());
        return joinNames(participants.getNames()) + joinRows(lines);
    }

    private static int getMaximumLengthOfNames(List<String> names) {
        return names.stream().mapToInt(String::length).max().getAsInt();
    }

    private String joinNames(final List<String> names) {
        String nameFormat = MessageFormat.format("%{0}s", rungLength + 1);
        String formattedNames = names.stream()
                .map(name -> String.format(nameFormat, name))
                .collect(Collectors.joining());
        return formattedNames + System.lineSeparator();
    }

    private String joinRows(final List<Line> lines) {
        final StringBuilder ladderBuilder = new StringBuilder();
        lines.forEach(line -> {
            ladderBuilder.append(LADDER_ROW_EMPTY.getDisplayUnit().repeat(rungLength));
            ladderBuilder.append(LADDER_COL.getDisplayUnit());
            ladderBuilder.append(joinUnitsOfRowFrom(line.getRungExistsAtEachColumn()));
            ladderBuilder.append(System.lineSeparator());
        });
        return ladderBuilder.toString();
    }

    private String joinUnitsOfRowFrom(final List<Boolean> rungExistsAtEachColumn) {
        final StringBuilder rowBuilder = new StringBuilder();
        rungExistsAtEachColumn.forEach(rungExists -> {
            rowBuilder.append(getRowDisplayUnitOf(rungExists).repeat(rungLength));
            rowBuilder.append(LADDER_COL.getDisplayUnit());
        });
        return rowBuilder.toString();
    }

    private String getRowDisplayUnitOf(boolean rungExistsAtColumn) {
        if (rungExistsAtColumn) {
            return LADDER_ROW_RUNG.getDisplayUnit();
        }
        return LADDER_ROW_EMPTY.getDisplayUnit();
    }
}
