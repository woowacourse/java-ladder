package ladder.domain.resource.line;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.resource.direction.Direction;

public class Line {

    private final List<Direction> directionsInfo;

    Line() {
        this.directionsInfo = new ArrayList<>();
    }

    void addDirection(Direction direction) {
        directionsInfo.add(direction);
    }

    public Direction getDirectionByIndex(int index) {
        return directionsInfo.get(index);
    }

    public Direction getLastDirection() {
        validateNotEmpty();
        return directionsInfo.get(directionsInfo.size() - 1);
    }

    public int getSize() {
        return directionsInfo.size();
    }

    public boolean isEmpty() {
        return directionsInfo.isEmpty();
    }

    private void validateNotEmpty() {
        if (isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 방향 정보가 없습니다.");
        }
    }

    public List<Direction> getDirections() {
        return directionsInfo;
    }
}
