package domain.result;

import domain.ladder.Height;
import domain.ladder.Ladder;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {

    private final Map<Position, Position> firstAndLastPosition;

    public LadderResult(Ladder ladder, int participantsCount) {
        firstAndLastPosition = new LinkedHashMap<>();
        initPosition(participantsCount);
        calculatePosition(ladder);
    }

    private void initPosition(int participantsCount) {
        for (int i = 0; i < participantsCount; i++) {
            firstAndLastPosition.put(new Position(i), new Position(i));
        }
    }

    private void calculatePosition(Ladder ladder) {
        Height currentHeight = new Height(0);
        while (!ladder.isFinish(currentHeight)) {
            moveAllPosition(ladder, currentHeight);
            currentHeight.moveUp();
        }
    }

    private void moveAllPosition(Ladder ladder, Height height) {
        for (Map.Entry<Position, Position> entry : firstAndLastPosition.entrySet()) {
            Position firstPosition = entry.getKey();
            moveEachPosition(ladder, height, firstPosition);
        }
    }

    private void moveEachPosition(Ladder ladder, Height height, Position firstPosition) {
        if (ladder.canMoveLeft(height, firstAndLastPosition.get(firstPosition).getPosition())) {
            firstAndLastPosition.get(firstPosition).movePositionLeft();
            return;
        }
        if (ladder.canMoveRight(height, firstAndLastPosition.get(firstPosition).getPosition())) {
            firstAndLastPosition.get(firstPosition).movePositionRight();
        }
    }

    public int getOneResult(int firstPositionValue) {
        return firstAndLastPosition.entrySet()
                .stream()
                .filter(positions -> positions.getKey().getPosition() == firstPositionValue)
                .mapToInt(positions -> positions.getValue().getPosition())
                .findFirst()
                .getAsInt();
    }
}
