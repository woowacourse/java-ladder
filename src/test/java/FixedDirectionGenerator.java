
import domain.ladder.common.Direction;
import util.DirectionGenerator;

import java.util.List;

public class FixedDirectionGenerator implements DirectionGenerator {
    List<Direction> fixedList;
    Integer index = 0;

    FixedDirectionGenerator(List<Direction> fixedList) {
        this.fixedList = fixedList;
    }

    @Override
    public Direction generate() {
        return fixedList.get(index++);
    }
}
