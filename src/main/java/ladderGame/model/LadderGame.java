package ladderGame.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final String EXCEPTION_MESSAGE_NOT_EQUALS_PLAYERS_LADDER_RESULTS = "사다리 결과 수가 참여자 수와 동일하지 않습니다.";

    private final Ladder ladder;
    private final Players players;
    private final LadderResults ladderResults;

    public LadderGame(Players players, LadderResults ladderResults, Ladder ladder) {
        validate(players, ladderResults);

        this.players = players;
        this.ladderResults = ladderResults;
        this.ladder = ladder;
    }

    private void validate(Players players, LadderResults ladderResults) {
        if (players.getPlayerSize() != ladderResults.getLadderResultsSize()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_EQUALS_PLAYERS_LADDER_RESULTS);
        }
    }

    public LadderResult findLadderGameResult(String name) {
        Integer startPosition = players.indexOfByName(name);

        int resultPosition = ladder.findLadderResultPosition(startPosition);
        return ladderResults.getLadderResults().get(resultPosition);
    }

    public Map<Player, LadderResult> findAllLadderGameResults() {
        Map<Player, LadderResult> ladderResultToPlayers = new LinkedHashMap<>();
        for (int index = 0; index < players.getPlayerSize(); index++) {
            int resultIndex = ladder.findLadderResultPosition(index);
            ladderResultToPlayers.put(players.getPlayer(index), ladderResults.getLadderResult(resultIndex));
        }

        return ladderResultToPlayers;
    }
}
