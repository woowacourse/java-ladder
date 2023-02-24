package ladder.domain.player;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Position;

public class Player {
    private final PlayerName name;
    private final Position position;

    public Player(final String name, final Position position) {
        this.name = new PlayerName(name);
        this.position = position;
    }

    public Position play(final Ladder ladder) {
        return ladder.play(position);
    }

    public boolean isSamePosition(final Position position) {
        return this.position == position;
    }

    public String getName() {
        return name.getValue();
    }
}
