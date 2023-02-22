package laddergame.view;

import static laddergame.view.LadderUnit.LADDER_COL;
import static laddergame.view.LadderUnit.LADDER_ROW_EMPTY;
import static laddergame.view.LadderUnit.LADDER_ROW_RUNG;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.LadderResult;
import laddergame.domain.LadderResultItem;
import laddergame.domain.Line;
import laddergame.domain.PersonalName;
import laddergame.domain.PersonalNames;

public class LadderFormGenerator {
    private int rungLength;

    public String generate(final PersonalNames personalNames, final LadderResult ladderResult, final List<Line> lines) {
        rungLength = getMaximumLengthOfNames(personalNames.getPersonalNames(), ladderResult.getResultItems());
        return joinNames(mapToValue(personalNames)) + joinRows(lines) + joinNames(mapToName(ladderResult));
    }

    private List<String> mapToValue(PersonalNames personalNames) {
        return personalNames.getPersonalNames().stream().map(PersonalName::getValue).collect(Collectors.toList());
    }

    private List<String> mapToName(LadderResult ladderResult) {
        return ladderResult.getResultItems().stream().map(LadderResultItem::getName).collect(Collectors.toList());
    }

    private int getMaximumLengthOfNames(final List<PersonalName> personalNames,
                                        final List<LadderResultItem> ladderResult) {
        int maxLengthOfNames = personalNames.stream().map(PersonalName::getValue).mapToInt(String::length).max()
                .getAsInt();
        int maxLengthOfItems = ladderResult.stream().map(LadderResultItem::getName).mapToInt(String::length).max()
                .getAsInt();
        return Math.max(maxLengthOfNames, maxLengthOfItems);
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
