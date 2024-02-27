package domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResult {

    public static final int ONE_STEP = 1;
    private Map<Integer, Integer> firstAndLastPosition;

    public LadderResult(Ladder ladder, int participantsCount) {
        initPosition(ladder, participantsCount);
        calculatePosition(0, ladder, participantsCount);
    }

    private void initPosition(Ladder ladder, int participantsCount) {
        this.firstAndLastPosition = IntStream.range(0, participantsCount)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> i));
    }

    private void calculatePosition(int floor, Ladder ladder, int participantsCount) {
        if (ladder.isFinish(floor)) {
            return;
        }
        for (int i = 0; i < participantsCount; i++) {
            canMove(ladder, floor, i);
        }
        calculatePosition(floor + 1, ladder, participantsCount);
    }

    private void canMove(Ladder ladder, int floor, int i) {
        if (ladder.canMoveLeft(floor, firstAndLastPosition.get(i))) {
            firstAndLastPosition.put(i, firstAndLastPosition.get(i) - ONE_STEP);
            return;
        }
        if (ladder.canMoveRight(floor, firstAndLastPosition.get(i))) {
            firstAndLastPosition.put(i, firstAndLastPosition.get(i) + ONE_STEP);
        }
    }

    public int getOneResult(int firstPosition) {
        return firstAndLastPosition.get(firstPosition);
    }
}
