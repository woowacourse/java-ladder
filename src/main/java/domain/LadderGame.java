package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final Persons persons;
    private final Ladder ladder;

    public LadderGame(Persons persons, Height height) {
        this.persons = persons;
        this.ladder = Ladder.generateRandomly(height, persons.getTotalPersonCount());
    }

    public List<List<Boolean>> getLadderStatus() {
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
