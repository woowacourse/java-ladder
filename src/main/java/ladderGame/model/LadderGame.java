package ladderGame.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final String EXCEPTION_MESSAGE_NOT_EQUALS_PLAYERS_LADDER_RESULTS = "사다리 결과 수가 참여자 수와 동일하지 않습니다.";
    private final String EXCEPTION_MESSAGE_NOT_CONTAIN_PLAYERS = "존재하지 않는 참가자 이름입니다.";

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
            throw new IllegalStateException(EXCEPTION_MESSAGE_NOT_EQUALS_PLAYERS_LADDER_RESULTS);
        }
    }

    public LadderResult findLadderGameResult(String name) {
        Integer startPosition = players.indexOf(name);

        if (startPosition == null) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_CONTAIN_PLAYERS);
        }

        int resultPosition = ladder.findLadderResultPosition(startPosition);
        return ladderResults.getLadderResults().get(resultPosition);
    }

    public Map<Player, LadderResult> findAllLadderGameResults() {
        Map<Player, LadderResult> ladderResultToPlayers = new LinkedHashMap<>();
        for (int position = 0; position < players.getPlayerSize(); position++) {
            int resultPosition = ladder.findLadderResultPosition(position);
            ladderResultToPlayers.put(players.getPlayer(position), ladderResults.getLadderResult(resultPosition));
        }

        return ladderResultToPlayers;
    }
}
