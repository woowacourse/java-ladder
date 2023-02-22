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
            int finalDestination = ladder.getDestinationOf(location++);
            String gameResultForOneLocation = ladderGameResult.get(finalDestination);
            gameRecord.add(gameResultForOneLocation);
        }
        players.recordGameResult(gameRecord);
    }

    public Map<Player, String> getAllLadderGameResult() {
        return players.getAllGameResult();
    }

    public Map.Entry<Player, String> getOneLadderGameResult(String playerName) {
        return players.getGameResultFor(playerName);
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getLadderGameResult() {
        return List.copyOf(ladderGameResult);
    }
}
