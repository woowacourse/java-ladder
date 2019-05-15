package domain;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.Random;

public class Floor {
    private final static int INIT_SECTOR_NUMBER = 0;

    private List<Boolean> stairs = new ArrayList<>();

    public Floor(int lineNum) {
        makeStairs(lineNum - 1);
    }

    private void makeStairs(int sector) {
        for (int sectorNum = INIT_SECTOR_NUMBER; sectorNum < sector; sectorNum++) {
            stairs.add(createStair());
            checkSector(sectorNum);
        }
    }

    private void checkSector(int sectorNum) {
        if (sectorNum > INIT_SECTOR_NUMBER) {
            replaceStair(sectorNum);
        }
    }

    private void replaceStair(int sectorNum) {
        if (stairs.get(sectorNum - 1)) {
            stairs.set(sectorNum, false);
        }
    }

    private boolean createStair() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public List<Boolean> getStairs() {
        return stairs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return stairs == floor.stairs;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stairs);
    }
}
