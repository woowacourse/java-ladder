package domain.ladder;

import domain.ladder.attirbute.Direction;
import util.DirectionGenerator;

import java.util.List;

public class FixedDirectionGenerator implements DirectionGenerator {
    private final List<Direction> fixedList;
    private int index = 0;

    FixedDirectionGenerator(List<Direction> fixedList) {
        this.fixedList = fixedList;
    }

    @Override
    public Direction generate() {
        return fixedList.get(index++);
    }
}
