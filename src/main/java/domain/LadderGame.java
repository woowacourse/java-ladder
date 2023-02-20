package domain;

import java.util.List;
import util.BridgeGenerator;
import util.RandomBridgeGenerator;

public class LadderGame {
    private final Persons persons;
    private final Ladder ladder;

    private final BridgeGenerator bridgeGenerator;

    public LadderGame(Persons persons, Height height) {
        this.persons = persons;
        this.ladder = new Ladder(height, persons.getTotalPersonCount());
        this.bridgeGenerator = new RandomBridgeGenerator();
    }

    public void run() {
        ladder.generate(bridgeGenerator);
    }

    public List<List<Bridge>> getLadderStatus() {
        return ladder.getStatus();
    }

    public List<String> getAllPlayers() {
        return persons.getAllPersonNames();
    }
}
