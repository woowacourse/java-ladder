package domain;

import exception.NotFindPersonException;

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

    public Map<String, String> getAllResult() {
        return ladderResult.entrySet()
                           .stream()
                           .collect(Collectors.toMap(
                                   key -> key.getKey().getName(),
                                   value -> value.getValue().getResult()));
    }

    public String getResultByName(String name) {
        Person findPerson = new Person(name);
        return ladderResult.entrySet()
                           .stream()
                           .filter(resultEntry -> resultEntry.getKey()
                                                             .equals(findPerson))
                           .findFirst()
                           .orElseThrow(NotFindPersonException::new)
                           .getValue()
                           .getResult();
    }
}
