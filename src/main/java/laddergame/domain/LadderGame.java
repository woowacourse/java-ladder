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

    public LadderGame(Players players, Ladder ladder, Prizes prizes) {
        List<Name> gameResults = initializeGameResult(ladder, prizes);

        playerGameResult = new LinkedHashMap<>();
        for (int i = 0; i < players.getPlayerNames().size(); i++) {
            playerGameResult.put(players.getPlayerNames().get(i), gameResults.get(i));
        }
    }

    public Name findPlayerResult(Name playerName) {
        if (!(playerGameResult.containsKey(playerName))) {
            throw new IllegalArgumentException("참여하지 않은 플레이어의 이름을 조회했습니다.");
        }

        return playerGameResult.get(playerName);
    }

    private List<Name> initializeGameResult(Ladder ladder, Prizes prizes) {
        List<Integer> resultIdx = ladder.getResultIndex(prizes.getPrizeNames().size());
        return resultIdx.stream()
                .map(idx -> prizes.getPrizeNames().get(idx))
                .toList();
    }

    public Map<Name, Name> getPlayerGameResult() {
        return playerGameResult;
    }
}
