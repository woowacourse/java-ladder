package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Floor> floors = new ArrayList<>();

    public Ladder(int size, int width) {
        validateSize(size);
        for (int i = 0; i < size; i++) {
            floors.add(new Floor(width));
        }
    }


    public void makeFloors(NumberGenerator numberGenerator) {
        for (Floor floor : floors) {
            floor.makeFloor(
                    generateFloorNumbers(numberGenerator, floor)
            );
        }
    }

    private List<Integer> generateFloorNumbers(NumberGenerator numberGenerator, Floor floor) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < floor.getLines().size(); i++) {
            numbers.add(numberGenerator.generate());
        }
        return numbers;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    private void validateSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("사다리의 높이는 1이상 입니다.");
        }
    }

}
