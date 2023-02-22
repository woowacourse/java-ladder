package ladder.domain;

import java.util.ArrayList;
import java.util.List;

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
}
