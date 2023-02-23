package domain;

import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 100;

    private final List<Floor> floors;

    public Ladder(int personNumber, int height, BooleanGenerator booleanGenerator) {
        validateHeight(height);
        floors = new ArrayList<>();
        addFloors(personNumber, height, booleanGenerator);
    }

    private static void validateHeight(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d 이상 %d 이하의 자연수만 입력해 주세요.", MIN_HEIGHT, MAX_HEIGHT)
            );
        }
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
