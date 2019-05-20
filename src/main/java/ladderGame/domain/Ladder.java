package ladderGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Floor> floors;

    public Ladder(int height, int userSize) {
        validatePositiveNumber(height);
        floors = createLadder(userSize, height);
    }

    private void validatePositiveNumber(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("숫자를 양수로 입력해주세요.");
        }
    }

    private List<Floor> createLadder(int floorSize, int height) {
        List<Floor> floors = new ArrayList<>();
        PointGenerator pointGenerator = new PointGenerator();

        for (int i = 0; i < height; i++) {
            floors.add(new Floor(pointGenerator.makePointList(floorSize)));
        }
        return floors;
    }

    public int getLadderHeight() {
        return  floors.size();
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
