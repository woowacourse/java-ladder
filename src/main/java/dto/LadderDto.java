package dto;

import java.util.List;
import model.items.Items;
import model.ladder.Ladder;
import model.people.People;

public record LadderDto(List<String> peopleNames, List<LineDto> lines, List<String> itemNames) {
    public static LadderDto from(final People people, final Ladder ladder, final Items items) {
        final List<String> peopleNames = people.getNames();
        final List<LineDto> lines = ladder.getLines()
                .stream()
                .map(LineDto::from)
                .toList();
        final List<String> itemNames = items.getNames();

        return new LadderDto(peopleNames, lines, itemNames);
    }
}
