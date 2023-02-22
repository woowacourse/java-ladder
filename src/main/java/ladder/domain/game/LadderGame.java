package ladder.domain.game;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final List<String> ladderGameResult;

    public LadderGame(Players players, Ladder ladder, List<String> ladderGameResult) {
        this.players = players;
        this.ladder = ladder;
        this.ladderGameResult = List.copyOf(ladderGameResult);
    }

    public void letPlayersToGoDown() {
        List<String> gameRecord = new ArrayList<>();
        int location = 0;

        for (int i = 0; i < players.size(); i++) {
            int finalDestinationForOnePlayer = ladder.getDestinationOf(location++);
            String gameResultForOnePlayer = ladderGameResult.get(finalDestinationForOnePlayer);
            gameRecord.add(gameResultForOnePlayer);
        }
        players.recordGameResult(gameRecord);
    }
}
