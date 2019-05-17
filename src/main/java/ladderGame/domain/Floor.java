package ladderGame.domain;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.Random;

public class Floor {
    private final List<Boolean> states = new ArrayList<>();

    public Floor(int width) {
        makeStairs(width);
    }

    private void makeStairs(int width) {
        for (int widthNum = 0; widthNum < width; widthNum++) {
            states.add(createStair());
            checkSector(widthNum);
        }
    }

    private void checkSector(int widthNum) {
        if (widthNum > 0) {
            replaceStair(widthNum);
        }
    }

    private void replaceStair(int sectorNum) {
        if (states.get(sectorNum - 1)) {
            states.set(sectorNum, false);
        }
    }

    private boolean createStair() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public List<Boolean> getStairs() {
        return states;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return states == floor.states;
    }

    @Override
    public int hashCode() {
        return Objects.hash(states);
    }
}
