package domain;

import exception.ErrorCode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;

public class LadderGame {
    private final Persons persons;
    private final Ladder ladder;
    private Map<String, String> mappingResult;

    private final BooleanGenerator booleanGenerator;

    public LadderGame(Persons persons, Height height) {
        this.persons = persons;
        this.ladder = Ladder.of(height, persons.getTotalPersonCount());
        this.mappingResult = new HashMap<>();
        this.booleanGenerator = new RandomBooleanGenerator();
    }

    public void run() {
        ladder.generate(booleanGenerator);
        persons.playGame(ladder);
    }

    public void makeGameResult(List<String> prizes) {
        for (int i = 0; i < prizes.size(); i++) {
            String name = persons.findPersonNameInPosition(i);
            String prize = prizes.get(i);
            mappingResult.put(name, prize);
        }
    }

    public String getPersonalResult(String inputName) {
        String result = mappingResult.get(inputName);
        if (result == null) {
            throw new IllegalArgumentException(ErrorCode.NOT_PLAYER.getMessage());
        }
        return result;
    }

    public Map<String, String> getAllResult() {
        return new HashMap<>(mappingResult);
    }

    public List<List<Bridge>> getLadderStatus() {
        return ladder.getStatus();
    }

    public List<String> getAllPlayerNames() {
        return persons.getAllPersonName();
    }
}
