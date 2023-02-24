package domain.game;

import domain.info.Names;
import domain.ladder.Floor;
import domain.ladder.Ladder;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final int MOVE_FORWARD = 1;
    private static final int MOVE_BACKWARD = -1;
    private static final int MOVE_STRAIGHT = 0;

    private final List<Integer> results;

    public LadderGame(final Names names, final Ladder ladder) {
        results = generateResults(names.getNamesSize(), ladder.getFloors());
    }

    private static List<Integer> generateResults(final int personCount, final List<Floor> floors) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < personCount; i++) {
            results.add(calculateResultIndex(floors, i));
        }

        return results;
    }

    private static int calculateResultIndex(final List<Floor> floors, int index) {
        for (Floor floor : floors) {
            index += calculateWeight(index, floor);
        }
        return index;
    }

    private static int calculateWeight(final int index, final Floor floor) {
        if (isAbleForward(index, floor)) {
            return MOVE_FORWARD;
        }
        if (isAbleBackward(index, floor)) {
            return MOVE_BACKWARD;
        }
        return MOVE_STRAIGHT;
    }

    private static boolean isAbleForward(final int index, final Floor floor) {
        return index < floor.getPointsSize() && floor.getPoint(index);
    }

    private static boolean isAbleBackward(final int index, final Floor floor) {
        return index > 0 && floor.getPoint(index - 1);
    }

    public int getResult(final int index) {
        return results.get(index);
    }
}
