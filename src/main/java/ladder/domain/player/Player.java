package ladder.domain.player;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Position;

public class Player {
    private final PlayerName name;
    private final Position position;

    private Player(final PlayerName name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public static Player of(final String name, final int index) {
        return new Player(new PlayerName(name), Position.valueOf(index));
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
