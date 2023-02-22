package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import util.BooleanGenerator;

public class LadderGame {
    private final Persons persons;
    private final Ladder ladder;
    private final WinningEntry winningEntry;

    public LadderGame(Persons persons, Height height, WinningEntry winningEntry, BooleanGenerator booleanGenerator) {
        this.persons = persons;
        this.ladder = Ladder.generate(booleanGenerator, height, persons.getTotalPersonCount());
        this.winningEntry = winningEntry;
    }

    public Map<String, String> play() {
        Map<String, String> winningResult = new LinkedHashMap<>();
        int resultPosition;
        for (int personIndex = 0; personIndex < persons.getTotalPersonCount(); personIndex++) {
            resultPosition = ladder.findDestination(personIndex);
            winningResult.put(persons.findNameByPosition(personIndex), winningEntry.findByPosition(resultPosition));
        }
        return winningResult;
    }

    public List<List<Boolean>> getLadder() {
        return ladder.getLines()
                .stream()
                .map(Line::getBridges)
                .collect(Collectors.toList());
    }

    public List<String> getAllPlayers() {
        return persons.getPersons()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }
}
