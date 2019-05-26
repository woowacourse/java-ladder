package ladder.domain;

import ladder.dto.PointsTupleDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<PointsTuple> canMoveForLines;

    Line(final List<PointsTuple> canMoveForLines) {
        if (isConsecutive(canMoveForLines)) {
            throw new IllegalArgumentException();
        }
        this.canMoveForLines = canMoveForLines;
    }

    private boolean isConsecutive(List<PointsTuple> canMoveForLines) {
        return canMoveForLines.contains(new PointsTuple(Arrays.asList(true, true)));
    }

    Direction determineDirection(int position) {
        return Direction.determine(canMoveForLines.get(position));
    }

    public List<PointsTupleDto> makeTupleDto() {
        return canMoveForLines.stream().map(o -> new PointsTupleDto(o.canMoveRight())).collect(Collectors.toList());
    }
}