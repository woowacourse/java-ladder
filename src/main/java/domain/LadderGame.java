package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.BridgeGenerator;
import util.RandomBridgeGenerator;

public class LadderGame {
    private final Persons persons;
    private final Ladder ladder;
    private final List<String> prizes;

    private final BridgeGenerator bridgeGenerator;

    public LadderGame(List<String> names, Height height, List<String> prizes) {
        this.persons = Persons.from(names);
        this.ladder = Ladder.of(height, persons.getTotalPersonCount());
        this.bridgeGenerator = new RandomBridgeGenerator();
        this.prizes = prizes;
    }

    public void run() {
        ladder.generate(bridgeGenerator);
        persons.playGame(ladder);
    }

    public Map<String, String> getGameResults() {
        Map<String, String> mappingResult = new HashMap<>();
        for (int i = 0; i < prizes.size(); i++) {
            String name = persons.findPersonNameInPosition(i);
            String prize = prizes.get(i);
            mappingResult.put(name, prize);
        }
        return mappingResult;
    }

    public List<List<Bridge>> getLadderStatus() {
        return ladder.getStatus();
    }

    public List<String> getAllPlayerNames() {
        return persons.getAllPersonName();
    }
}
