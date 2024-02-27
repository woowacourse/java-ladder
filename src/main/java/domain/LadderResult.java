package domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResult {

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
            System.out.println("floor" + floor + " 사람" + i + " 현재 위치" + firstAndLastPosition.get(i));
            canMove(ladder, floor, i);
            System.out.println("floor" + floor + " 사람" + i + " 바뀐 위치" + firstAndLastPosition.get(i));
        }
        calculatePosition(floor + 1, ladder, participantsCount);
    }

    private void canMove(Ladder ladder, int floor, int i) {
        if (ladder.canMoveLeft(floor, firstAndLastPosition.get(i))) {
            firstAndLastPosition.put(i, firstAndLastPosition.get(i) - 1);
            return;
        }
        if (ladder.canMoveRight(floor, firstAndLastPosition.get(i))) {
            firstAndLastPosition.put(i, firstAndLastPosition.get(i) + 1);
        }
    }

    public Map<Integer, Integer> getAllResult() {
        return firstAndLastPosition;
    }

    public int getOneResult(int firstPosition) {
        return firstAndLastPosition.get(firstPosition);
    }
}
