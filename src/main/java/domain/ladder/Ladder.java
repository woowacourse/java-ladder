package domain.ladder;

import domain.info.Names;
import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Ladder {
    private final List<Floor> floors;

    public Ladder(final Names names, final Height height, final BooleanGenerator booleanGenerator) {
        floors = generateFloors(names.getNamesSize(), height.getValue(), booleanGenerator);
    }

    private static List<Floor> generateFloors(final int personNumber,
                                              final int height,
                                              final BooleanGenerator booleanGenerator) {
        List<Floor> floors = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            floors.add(new Floor(personNumber, booleanGenerator));
        }

        return floors;
    }

    public List<Floor> getFloors() {
        return List.copyOf(floors);
    }
}
