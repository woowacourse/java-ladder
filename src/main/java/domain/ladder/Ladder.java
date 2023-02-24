package domain.ladder;

import domain.info.Names;
import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Ladder {
    private final List<Floor> floors;

    public Ladder(final Names names, final Height height, final BooleanGenerator booleanGenerator) {
        floors = new ArrayList<>();
        addFloors(names.getNamesSize(), height.getValue(), booleanGenerator);
    }

    private void addFloors(int personNumber, int height, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < height; i++) {
            floors.add(new Floor(personNumber, booleanGenerator));
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
