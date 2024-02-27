package ladderGame.model;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final String EXCEPTION_MESSAGE_NOT_CONTAIN_PLAYERS = "존재하지 않는 참가자 이름입니다.";

    private final Ladder ladder;
    private final Players players;
    private final LadderResults ladderResults;

    public LadderGame(Players players, LadderResults ladderResults, Ladder ladder) {
        this.players = players;
        this.ladderResults = ladderResults;
        this.ladder = ladder;
    }

    public LadderResult findLadderGameResult(String name) {
        Integer startIndex = players.indexOfPlayerByName(name);

        if (startIndex == null) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_CONTAIN_PLAYERS);
        }

        int resultIndex = ladder.findLadderResultIndex(startIndex);
        return ladderResults.getLadderResults().get(resultIndex);
    }

    public Map<Player, LadderResult> findAllLadderGameResults() {
        Map<Player, LadderResult> ladderResultToPlayers = new HashMap<>();
        for (int index = 0; index < players.getPlayerSize(); index++) {
            int resultIndex = ladder.findLadderResultIndex(index);
            ladderResultToPlayers.put(players.getPlayer(index), ladderResults.getLadderResult(resultIndex));
        }

        return ladderResultToPlayers;
    }
}
