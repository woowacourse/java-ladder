package domain;

import exception.NotFindPersonException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String GET_RESULT_ALL = "all";

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

    public Map<String, String> getResult(String requireValue) {
        if (GET_RESULT_ALL.equals(requireValue)) {
            return getAllResult();
        }

        Map<String, String> resultByName = getResultByName(requireValue);
        if (resultByName.isEmpty()) {
            throw new NotFindPersonException();
        }

        return resultByName;
    }

    private Map<String, String> getAllResult() {
        return ladderResult.entrySet()
                           .stream()
                           .collect(Collectors.toMap(
                                   key -> key.getKey().getName(),
                                   value -> value.getValue().get()));
    }

    private Map<String, String> getResultByName(String name) {
        Person findPerson = new Person(name);
        return ladderResult.entrySet()
                           .stream()
                           .filter(resultEntry -> resultEntry.getKey().equals(findPerson))
                           .collect(Collectors.toMap(
                                   key -> key.getKey().getName(),
                                   value -> value.getValue().get()));
    }
}
