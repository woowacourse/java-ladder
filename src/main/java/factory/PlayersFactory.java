package factory;

import domain.Player;
import domain.Players;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersFactory {

    public static Players generate(final List<String> playerNames) {
        return new Players(generatePlayers(playerNames));
    }

    private static List<Player> generatePlayers(List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

}
