package ladder.domain.ladder;

import ladder.domain.Name;
import ladder.domain.Position;

public class Reward {
    private final Name name;
    private final Position position;

    public Reward(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public String getName() {
        return name.getValue();
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }
}
