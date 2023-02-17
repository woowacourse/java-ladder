package domain;

import java.util.List;
import java.util.stream.Collectors;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;

public class LadderGame {
    private final Persons persons;
    private final Ladder ladder;
    private final BooleanGenerator booleanGenerator;

    public LadderGame(Persons persons, Height height) {
        this.persons = persons;
        this.ladder = new Ladder(height, persons.getTotalPersonCount());
        this.booleanGenerator = new RandomBooleanGenerator();
    }

    public void run() {
        ladder.generateLadder(booleanGenerator);
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
