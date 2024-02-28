package dto;

import java.util.List;
import model.Items;
import model.Ladder;
import model.People;

public record LadderInfo(List<String> peopleNames, List<LineInfo> lines, List<String> itemNames) {
    public static LadderInfo from(final People people, final Ladder ladder, final Items items) {
        final List<String> peopleNames = people.getNames();
        final List<LineInfo> lines = ladder.getLines()
                .stream()
                .map(LineInfo::from)
                .toList();
        final List<String> itemNames = items.getNames();

        return new LadderInfo(peopleNames, lines, itemNames);
    }
}
