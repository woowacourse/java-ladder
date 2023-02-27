package laddergame.domain.ladder.line;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.generator.StepPointGenerator;
import laddergame.util.IndexValidator;

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
        for (int i = 0; i < (width - 1); i++) {
            StepPoint generated = generateStepPoint(stepPointGenerator, left);
            directions.add(Direction.findDirection(left, generated));
            left = generated;
        }
        directions.add(Direction.findDirection(left, StepPoint.NONE));

        return directions;
    }

    private static StepPoint generateStepPoint(StepPointGenerator stepPointGenerator, StepPoint left) {
        StepPoint generated = stepPointGenerator.generate(left);
        validateStepPoint(left, generated);
        return generated;
    }

    private static void validateStepPoint(StepPoint previous, StepPoint toAdd) {
        if (previous.isContinuous(toAdd)) {
            throw new IllegalArgumentException("디딤대는 연속적으로 존재할 수 없습니다.");
        }
    }

    public int findNextLineIndex(int index) {
        IndexValidator.validateBounds(directions, index);
        Direction direction = directions.get(index);
        return direction.computeNextIndex(index);
    }

    public int size() {
        return directions.size();
    }

    public List<Direction> toDirections() {
        return new ArrayList<>(directions);
    }

    public List<StepPoint> toStepPointsInLine() {
        List<StepPoint> stepPoints = new ArrayList<>();
        for (int i = 0; i < (directions.size() - 1); i++) {
            Direction direction = directions.get(i);
            stepPoints.add(direction.getRightStepPoint());
        }
        return stepPoints;
    }
}
