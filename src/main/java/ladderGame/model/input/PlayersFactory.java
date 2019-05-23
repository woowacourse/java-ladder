package ladderGame.model.input;

import java.util.List;

public class PlayersFactory {

    public static Players getPlayers(List<String> splittedInput) {
        Players players = new Players(splittedInput);
        return players;
    }
}
