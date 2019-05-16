package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGamePlayers {

    private List<Player> players;

    public LadderGamePlayers(List<Player> players) {
        this.players = players;
    }

    public List<String> getAlignedNames() {
        return players.stream().map(Player::getAlignedName).collect(Collectors.toList());
    }

    public int size() {
        return players.size();
    }
}
