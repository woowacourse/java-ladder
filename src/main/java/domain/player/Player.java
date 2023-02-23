package domain.player;

import domain.Position;
import domain.item.Item;
import domain.ladder.Bridge;
import domain.ladder.Line;

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

    public void goToResult(List<Line> ladder, List<Item> items) {
        int ladderHeight = ladder.size();
        for (int i = 0; i < ladderHeight; i++) {
            Line targetLine = ladder.get(position.getY());
            findPath(targetLine.getBridges());
        }
        int itemIndex = position.getX();
        this.result = items.get(itemIndex).getItem();
    }

    private void findPath(List<Bridge> targetLine) {
        if (isLeftPassable(targetLine)) {
            position.moveLeft();
            return;
        }
        if (isRightPassable(targetLine)) {
            position.moveRight();
            return;
        }
        position.moveDown();
    }

    private boolean isLeftPassable(List<Bridge> targetLine) {
        if (position.getX() == 0)   // 가장 왼쪽에 있다면 왼쪽으로 못 감
            return false;

        // 왼쪽에 다리가 있는지는 targetLine의 x-1번째 요소가 Passable인지 확인
        Bridge left = targetLine.get(position.getX() - 1);
        return left.isPassable();
    }

    private boolean isRightPassable(List<Bridge> targetLine) {
        if (position.getX() == targetLine.size())   // 가장 오른쪽에 있다면 오른쪽으로 못 감
            return false;

        // 오른쪽에 다리가 있는지는 targetLine의 x번째 요소가 Passable인지 확인
        Bridge right = targetLine.get(position.getX());
        return right.isPassable();
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
