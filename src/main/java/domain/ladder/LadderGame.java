package domain.ladder;

import static java.util.stream.Collectors.toList;

import domain.player.Player;
import domain.player.Players;
import dto.PlayerLadderResult;
import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;

    public LadderGame(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public boolean isPlayerExistByName(String name) {
        return players.containPlayerBySpecificName(name);
    }

    public List<PlayerLadderResult> findAllPlayerResult() {
        return players.stream()
                .map(player -> {
                    LadderResult ladderResult = ladder.play(player);
                    return new PlayerLadderResult(player.getName(), ladderResult.getResult());
                })
                .collect(toList());
    }

    public LadderResult findSinglePlayerResultByName(String name) {
        Player findPlayer = players.findSpecificNamePlayer(name);
        return ladder.play(findPlayer);
    }
}
