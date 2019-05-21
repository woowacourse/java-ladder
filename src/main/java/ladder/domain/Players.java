package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public void checkParticipant(String name) {
        if (Objects.isNull(name) || (!containsPlayer(name) && !name.equals("all"))) {
            System.err.println("해당 참가자가 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    private boolean containsPlayer(String name) {
        boolean result = false;

        for (Player player : players) {
            result = result || player.isEqualName(name);
        }

        return result;
    }

    public int getIndex(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).isEqualName(name)) {
                return i;
            }
        }

        return 0;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
