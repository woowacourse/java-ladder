package laddergame.domain;

import laddergame.domain.gameelements.Name;
import laddergame.domain.gameelements.Elements;
import laddergame.domain.ladder.Ladder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Map<Name, Name> playerGameResult;

    public LadderGame(Elements people, Ladder ladder, Elements results) {
        List<Name> gameResults = initializeGameResult(ladder, results);

        playerGameResult = new LinkedHashMap<>();
        for (int i = 0; i < people.getElements().size(); i++) {
            playerGameResult.put(people.getElements().get(i), gameResults.get(i));
        }
    }

    public Name findPlayerResult(Name playerName) {
        if (!(playerGameResult.containsKey(playerName))) {
            throw new IllegalArgumentException("참여하지 않은 플레이어의 이름을 조회했습니다.");
        }

        return playerGameResult.get(playerName);
    }

    private List<Name> initializeGameResult(Ladder ladder, Elements results) {
        List<Integer> resultIdx = ladder.move(results.getElements().size());
        return resultIdx.stream()
                .map(idx -> results.getElements().get(idx))
                .toList();
    }

    public Map<Name, Name> getPlayerGameResult() {
        return playerGameResult;
    }
}
