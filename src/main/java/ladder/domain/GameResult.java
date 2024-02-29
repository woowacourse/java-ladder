package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;

public class GameResult {

    private final Map<Name, Prize> gameResult;

    public GameResult(Participants participants, Prizes sortedPrizes) {
        this.gameResult = makeLadderGameResult(participants, sortedPrizes);
    }

    private Map<Name, Prize> makeLadderGameResult(Participants participants, Prizes sortedPrizes) {
        Map<Name, Prize> gameResult = new LinkedHashMap<>();

        for (int index = 0; index < participants.getCount(); index++) {
            gameResult.put(participants.getNameByIndex(index), sortedPrizes.getPrizeByIndex(index));
        }

        return gameResult;
    }

    public void containsName(String nameInput) {
        if (isNameNotContained(nameInput)) {
            throw new IllegalArgumentException("조회하려는 참여자가 게임 결과에 존재하지 않습니다.");
        }
    }

    private boolean isNameNotContained(String nameInput) {
        return !gameResult.containsKey(new Name(nameInput));
    }

    public Map<Name, Prize> getGameResult() {
        return gameResult;
    }
}
