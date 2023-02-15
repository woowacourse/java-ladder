package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.RandomBooleanGenerator;

public class Floors {
    private final List<Floor> floors = new ArrayList<>();

    public Floors(int personCount, int floorCount) {
        if (floorCount < 1 || floorCount > 100) {
            throw new IllegalArgumentException();
        }
        for (int count = 0; count < floorCount; count++) {
            floors.add(new Floor(personCount, new RandomBooleanGenerator()));
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }

}
