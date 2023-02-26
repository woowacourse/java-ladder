package factory;

import domain.Player;
import domain.Players;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersFactory {

    public static Players of(final List<String> playerNames) {
        return new Players(generatePlayers(playerNames));
    }

    private static List<Player> generatePlayers(final List<String> playerNames) {
        return playerNames.stream()
                .map((String name) -> new Player(name, playerNames.indexOf(name)))
                .collect(Collectors.toUnmodifiableList());
    }

}
