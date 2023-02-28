package laddergame.player;

import laddergame.ladder.Ladder;
import laddergame.vo.PlayerName;
import laddergame.vo.Position;

import java.util.Objects;

public class Player {
    private final PlayerName playerName;
    private final Position position;

    public Player(String playerName, int position) {
        this.playerName = new PlayerName(playerName);
        this.position = new Position(position);
    }

    public Position climbDownLadder(Ladder ladder) {
        return ladder.climbDownFrom(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player p = (Player) o;
        return Objects.equals(playerName, p.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }

    public String getName() {
        return playerName.getName();
    }
}
