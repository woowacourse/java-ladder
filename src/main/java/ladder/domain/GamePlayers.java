package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public final class GamePlayers {
    private final List<Player> players;

    public GamePlayers(final List<Player> players) {
        validateSize(players);
        this.players = new ArrayList<>(players);
    }

    private void validateSize(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public int index(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public String getPlayerName(int index){
        return players.get(index).getName();
    }
    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
