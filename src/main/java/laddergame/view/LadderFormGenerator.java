package laddergame.view;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.LadderResult;
import laddergame.domain.LadderResultItem;
import laddergame.domain.Line;
import laddergame.domain.PersonalName;
import laddergame.domain.PersonalNames;

public class LadderFormGenerator {
    private final String LADDER_ROW_RUNG = "-";
    private final String LADDER_ROW_EMPTY = " ";
    private final String LADDER_COL = "|";

    private int rungLength;

    public String generate(final PersonalNames personalNames, final LadderResult ladderResult, final List<Line> lines) {
        List<String> values = mapToValue(personalNames);
        List<String> itemNames = mapToName(ladderResult);
        rungLength = getMaximumElementLengthOf(concat(values, itemNames));
        return joinNames(mapToValue(personalNames)) + joinRows(lines) + joinNames(mapToName(ladderResult));
    }

    private List<String> concat(List<String> values, List<String> itemNames) {
        return Arrays.asList(values, itemNames).stream().flatMap(list -> list.stream()).collect(Collectors.toList());
    }

    private List<String> mapToValue(PersonalNames personalNames) {
        return personalNames.getPersonalNames().stream().map(PersonalName::getValue).collect(Collectors.toList());
    }

    private List<String> mapToName(LadderResult ladderResult) {
        return ladderResult.getResultItems().stream().map(LadderResultItem::getName).collect(Collectors.toList());
    }

    private int getMaximumElementLengthOf(final List<String> names) {
        return names.stream().mapToInt(String::length).max().getAsInt();
    }

    private String joinNames(final List<String> names) {
        String nameFormat = MessageFormat.format("%{0}s", rungLength + 1);
        String formattedNames = names.stream().map(name -> String.format(nameFormat, name))
                .collect(Collectors.joining());
        return formattedNames + System.lineSeparator();
    }

    private String joinRows(final List<Line> lines) {
        final StringBuilder ladderBuilder = new StringBuilder();
        lines.forEach(line -> {
            ladderBuilder.append(LADDER_ROW_EMPTY.repeat(rungLength));
            ladderBuilder.append(LADDER_COL);
            ladderBuilder.append(joinUnitsOfRowFrom(line.getRungExistsAtEachColumn()));
            ladderBuilder.append(System.lineSeparator());
        });
        return ladderBuilder.toString();
    }

    private String joinUnitsOfRowFrom(final List<Boolean> rungExistsAtEachColumn) {
        final StringBuilder rowBuilder = new StringBuilder();
        rungExistsAtEachColumn.forEach(rungExists -> {
            rowBuilder.append(getRowDisplayUnitOf(rungExists).repeat(rungLength));
            rowBuilder.append(LADDER_COL);
        });
        return rowBuilder.toString();
    }

    private String getRowDisplayUnitOf(boolean rungExistsAtColumn) {
        if (rungExistsAtColumn) {
            return LADDER_ROW_RUNG;
        }
        return LADDER_ROW_EMPTY;
    }
}
