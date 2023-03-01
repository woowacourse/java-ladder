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
    private final List<String> destinations;

    public LadderGame(Players players, Ladder ladder, List<String> destinations) {
        this.players = players;
        this.ladder = ladder;
        this.destinations = List.copyOf(destinations);
    }

    public void makeGameResult() {
        List<String> gameRecord = new ArrayList<>();

        for (int location = 0; location < players.size(); location++) {
            int finalDestination = ladder.getDestinationOf(location);
            String gameResultForOneLocation = destinations.get(finalDestination);
            gameRecord.add(gameResultForOneLocation);
        }
        players.recordGameResult(gameRecord);
    }

    public Map<Player, String> getAllLadderGameResult() {
        return players.getAllGameRecords();
    }

    public Map.Entry<Player, String> getOneLadderGameResult(String playerName) {
        return players.getGameRecordFor(playerName);
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getDestinations() {
        return List.copyOf(destinations);
    }
}
