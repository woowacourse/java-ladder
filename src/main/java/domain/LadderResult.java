package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {

    private final Map<Position, Position> firstAndLastPosition;

    public LadderResult(Ladder ladder, int participantsCount) {
        firstAndLastPosition = new LinkedHashMap<>();
        initPosition(ladder, participantsCount);
        calculatePosition(ladder);
    }

    private void initPosition(Ladder ladder, int participantsCount) {
        for (int i = 0; i < participantsCount; i++) {
            firstAndLastPosition.put(new Position(i), new Position(i));
        }
    }

    private void calculatePosition(Ladder ladder) {
        for (int floor = 0; !ladder.isFinish(floor); floor++) {
            moveAllPosition(ladder, floor);
        }
    }

    private void moveAllPosition(Ladder ladder, int floor) {
        for (Map.Entry<Position, Position> entry : firstAndLastPosition.entrySet()) {
            Position firstPosition = entry.getKey();
            moveEachPosition(ladder, floor, firstPosition);
        }
    }

    private void moveEachPosition(Ladder ladder, int floor, Position firstPosition) {
        if (ladder.canMoveLeft(floor, firstAndLastPosition.get(firstPosition).getPosition())) {
            firstAndLastPosition.get(firstPosition).movePositionLeft();
            return;
        }
        if (ladder.canMoveRight(floor, firstAndLastPosition.get(firstPosition).getPosition())) {
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
