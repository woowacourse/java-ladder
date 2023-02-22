package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {

   private final Map<Person, Result> ladderResult = new HashMap<>();

    public LadderGame(Participants participants, Ladder ladder, Results results) {
        playGame(participants, ladder, results);
    }

    public void playGame(Participants participants, Ladder ladder, Results results) {
        for (int index = 0; index < participants.getParticipantCount(); index++) {
            int resultIndex = ladder.getResultIndex(index);
            ladderResult.put(participants.getByIndex(index), results.getByIndex(resultIndex));
        }
    }

    public Map<String, String> getResult() {
        return ladderResult.entrySet()
                           .stream()
                           .collect(Collectors.toMap(
                                   key -> key.getKey().getName(),
                                   value -> value.getValue().get()));
    }
}
