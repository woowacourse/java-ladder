package ladder.domain.resource.line;

import java.util.List;
import ladder.domain.resource.direction.Direction;

public class Line {

    private static final int MIN_DIRECTION_SIZE = 2;
    private static final int MAX_DIRECTION_SIZE = 10;

    private final List<Direction> directionInfo;

    public Line(List<Direction> directionInfo) {
        validateDirectionSize(directionInfo);
        this.directionInfo = directionInfo;
    }

    public Direction getDirectionByIndex(int index) {
        return directionInfo.get(index);
    }

    public int getSize() {
        return directionInfo.size();
    }

    public boolean isEmpty() {
        return directionInfo.isEmpty();
    }

    private void validateDirectionSize(List<Direction> directions) {
        if (directions.size() < MIN_DIRECTION_SIZE || directions.size() > MAX_DIRECTION_SIZE) {
            throw new IllegalArgumentException("[ERROR] 방향은 2~10개 까지만 등록 가능합니다.");
        }
    }

    public List<Direction> getDirectionInfo() {
        return directionInfo;
    }
}
