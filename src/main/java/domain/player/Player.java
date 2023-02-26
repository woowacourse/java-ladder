package domain.player;

import domain.item.Item;
import domain.ladder.Ladder;

import java.util.List;
import java.util.Objects;

public class Player {

    private final Name name;
    private final Position position;
    private String result;

    public Player(String name, int index) {
        this.name = new Name(name);
        this.position = new Position(index);
    }

    public void findGameResult(Ladder ladder, List<Item> items) {
        int ladderHeight = ladder.getHeight();
        for (int i = 0; i < ladderHeight; i++) {
            findPath(ladder, position);
        }
        int itemIndex = position.getX();
        this.result = items.get(itemIndex).getItem();
    }

    private void findPath(Ladder ladder, Position position) {
        if (ladder.isLeftPassable(position)) {
            position.moveLeft();
            return;
        }
        if (ladder.isRightPassable(position)) {
            position.moveRight();
            return;
        }
        position.moveDown();
    }

    public String getName() {
        return name.getName();
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name.getName(), player.name.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.getName());
    }
}
