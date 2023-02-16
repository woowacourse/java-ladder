package domain;

import java.util.List;
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
        return ladder.getStatus();
    }

    public List<String> getAllPlayers() {
        return persons.getAllPersonNames();
    }
}
