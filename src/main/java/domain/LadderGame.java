package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final List<Integer> gameResults;

    public LadderGame(List<Floor> floors) {
        gameResults = new ArrayList<>();
        startGame(floors);
    }

    private void startGame(List<Floor> floors) {
        for (int i = 0; i < calculatePersonCount(floors); i++) {
            gameResults.add(calculateResultIndex(floors, i));
        }
    }

    private int calculatePersonCount(List<Floor> floors) {
        return floors.get(0).getLineSize() + 1;
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
        return index < floor.getLineSize() && floor.getLine().get(index);
    }

    private boolean isAbleBackward(int index, Floor floor) {
        return index > 0 && floor.getLine().get(index - 1);
    }

    public List<Integer> getResult() {
        return gameResults;
    }

    public int getResult(int index) {
        return gameResults.get(index);
    }
}
