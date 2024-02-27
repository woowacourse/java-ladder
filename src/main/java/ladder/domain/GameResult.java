package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;

public class GameResult {

    private final Map<Name, String> gameResult;

    public GameResult(Participants participants, Prizes prizes) {
        this.gameResult = makeLadderGameResult(participants, prizes);
    }

    private Map<Name, String> makeLadderGameResult(Participants participants, Prizes prizes) {
        Map<Name, String> gameResult = new HashMap<>();

        IntStream.range(0, participants.getCount())
                .forEach(index -> gameResult.put(participants.getNameByIndex(index),
                        prizes.getNameByIndex(index)));

        return gameResult;
    }

    public void containsName(String personNameInput) {
        Name personName = new Name(personNameInput);
        if (!gameResult.containsKey(personName)) {
            throw new IllegalArgumentException("조회하려는 사람이 존재하지 않습니다.");
        }
    }

    public Map<Name, String> getGameResult() {
        return gameResult;
    }
}
