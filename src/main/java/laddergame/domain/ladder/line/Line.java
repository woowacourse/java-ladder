package laddergame.domain.ladder.line;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.generator.StepPointGenerator;
import laddergame.domain.util.ExceptionMessageFormatter;

public class Line {

    private final List<Direction> directions;

    private Line(List<Direction> directions) {
        this.directions = directions;
    }

    public static Line of(StepPointGenerator stepPointGenerator, LineWidth width) {
        return new Line(generateDirections(stepPointGenerator, width.get()));
    }

    private static List<Direction> generateDirections(StepPointGenerator stepPointGenerator, int width) {
        List<Direction> directions = new ArrayList<>();

        StepPoint left = StepPoint.NONE;
        for (int i = 0; i < width - 1; i++) {
            StepPoint generated = stepPointGenerator.generate(left);
            validateStepPoint(left, generated);
            Direction direction = Direction.findDirection(left, generated);
            directions.add(direction);
            left = generated;
        }
        directions.add(Direction.findDirection(left, StepPoint.NONE));
        return directions;
    }

    private static void validateStepPoint(StepPoint previous, StepPoint toAdd) {
        if (previous.isContinuous(toAdd)) {
            throw new IllegalArgumentException("디딤대는 연속적으로 존재할 수 없습니다.");
        }
    }

    public int size() {
        return directions.size();
    }

    public List<Direction> toDirections() {
        return new ArrayList<>(directions);
    }

    public Direction getDirectionToMove(int index) {
        validateIndex(index);
        return directions.get(index);
    }

    private void validateIndex(int index) {
        if (index < -1 || index > size() - 1) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("주어진 위치가 사다리 폭보다 큽니다.", index)
            );
        }
    }
}
