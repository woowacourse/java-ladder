package domain;

import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 100;

    private final List<Floor> floors = new ArrayList<>();

    public Ladder(int personNumber, int height, BooleanGenerator booleanGenerator) {
        validateHeight(height);
        for (int i = 0; i < height; i++) {
            Floor floor = new Floor(personNumber, booleanGenerator);
            floors.add(floor);
        }
    }

    private static void validateHeight(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d 이상 %d 이하의 자연수만 입력해 주세요.", MIN_HEIGHT, MAX_HEIGHT)
            );
        }
    }

    public List<Floor> getLines() {
        return floors;
    }
}
