package ladder.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.domain.Player;

public class PlayerRepository {
    private final List<Player> players = new ArrayList<>();

    public void saveAll(List<Player> players) {
        this.players.addAll(players);
    }

    public int countBy() {
        return players.size();
    }

    public List<Player> findAll() {
        return Collections.unmodifiableList(players);
    }

    public int findIndexByPlayer(Player player) {
        int index = players.indexOf(player);
        if (index == -1) {
            throw new IllegalArgumentException("[ERROR] 해당 참여자가 없습니다.");
        }
        return index;
    }
}
