package laddergame.domain;

import laddergame.domain.gameelements.Name;
import laddergame.domain.gameelements.Players;
import laddergame.domain.gameelements.Prizes;
import laddergame.domain.ladder.Ladder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Map<Name, Name> playerGameResult;

    public LadderGame(Players people, Ladder ladder, Prizes prizes) {
        List<Name> gameResults = initializeGameResult(ladder, prizes);

        playerGameResult = new LinkedHashMap<>();
        for (int i = 0; i < people.getPlayerNames().size(); i++) {
            playerGameResult.put(people.getPlayerNames().get(i), gameResults.get(i));
        }
    }

    public Name findPlayerResult(Name playerName) {
        if (!(playerGameResult.containsKey(playerName))) {
            throw new IllegalArgumentException("참여하지 않은 플레이어의 이름을 조회했습니다.");
        }

        return playerGameResult.get(playerName);
    }

    private List<Name> initializeGameResult(Ladder ladder, Prizes prizes) {
        List<Integer> resultIdx = ladder.move(prizes.getPrizeNames().size());
        return resultIdx.stream()
                .map(idx -> prizes.getPrizeNames().get(idx))
                .toList();
    }

    public Map<Name, Name> getPlayerGameResult() {
        return playerGameResult;
    }
}
