package domain.player;

import domain.ladder.LadderHeight;

import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Players {
    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = players;
    }

    public static Players of(final PlayerNames playerNames, final LadderHeight ladderHeight) {
        List<String> playerNameValues = playerNames.getPlayerNames();
        return range(0, playerNameValues.size())
                .mapToObj(userNameIndex -> Player.of(playerNameValues.get(userNameIndex), userNameIndex + 1, ladderHeight.value()))
                .collect(collectingAndThen(toList(), Players::new));
    }

    public List<Player> getPlayers() {
        return unmodifiableList(players);
    }
}
