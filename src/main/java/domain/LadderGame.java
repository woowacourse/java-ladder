package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final List<Integer> results;

    public LadderGame(Names names, Ladder ladder) {
        results = generateResults(names.getNamesSize(), ladder.getFloors());
    }

    private List<Integer> generateResults(int personCount, List<Floor> floors) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < personCount; i++) {
            results.add(calculateResultIndex(floors, i));
        }

        return results;
    }

    private int calculateResultIndex(List<Floor> floors, int index) {
        for (Floor floor : floors) {
            index += calculateWeight(index, floor);
        }
        return index;
    }

    private int calculateWeight(int index, Floor floor) {
        if (isAbleForward(index, floor)) {
            return 1;
        }
        if (isAbleBackward(index, floor)) {
            return -1;
        }
        return 0;
    }

    private boolean isAbleForward(int index, Floor floor) {
        return index < floor.getPointsSize() && floor.getPoint(index);
    }

    private boolean isAbleBackward(int index, Floor floor) {
        return index > 0 && floor.getPoint(index - 1);
    }

    public List<Integer> getResult() {
        return results;
    }

    public int getResult(int index) {
        return results.get(index);
    }
}
