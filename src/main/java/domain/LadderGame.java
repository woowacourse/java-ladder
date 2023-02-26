package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {

    private final Participants participants;
    private final Results results;
    private final Ladder ladder;
    private final GameResult gameResult;

    public LadderGame(Participants participants, Results results, Ladder ladder) {
        this.participants = participants;
        this.results = results;
        this.ladder = ladder;
        this.gameResult = playGame(participants, ladder, results);
    }

    public GameResult playGame(Participants participants, Ladder ladder, Results results) {
        final Map<Person, Result> ladderResult = new HashMap<>();
        for (int index = 0; index < participants.getParticipantCount(); index++) {
            int resultIndex = ladder.getResultIndex(index);
            ladderResult.put(participants.getByIndex(index), results.getByIndex(resultIndex));
        }
        return new GameResult(ladderResult);
    }

    public List<String> getParticipants() {
        return participants.getParticipantNames()
                           .stream()
                           .map(Person::getName)
                           .collect(Collectors.toList());
    }

    public List<String> getResults() {
        return results.getResult()
                      .stream()
                      .map(Result::getResult)
                      .collect(Collectors.toList());
    }

    public List<List<Boolean>> getLadder() {
        List<List<Boolean>> ladderStatus = new ArrayList<>();
        for (Line line : ladder.getLines()) {
            List<Boolean> lineStatus = new ArrayList<>();
            line.getStatus()
                .forEach(status -> lineStatus.add(status.isConnected()));
            ladderStatus.add(lineStatus);
        }
        return List.copyOf(ladderStatus);
    }

    public Map<String, String> getGameAllResult() {
        return gameResult.getAllResult()
                         .entrySet()
                         .stream()
                         .collect(Collectors.toMap(
                                 key -> key.getKey().getName(),
                                 value -> value.getValue().getResult()));
    }

    public String getGameResultByName(String name) {
        return gameResult.getResultByName(name)
                         .getResult();
    }
}
