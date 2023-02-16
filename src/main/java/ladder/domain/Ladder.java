package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final static int DIFFERENCE_BETWEEN_FLOOR_AND_USERS = 1;
    private List<Floor> floors = new ArrayList<>();

    public Ladder(int size, Users users) {
        validateSize(size);
        int width = calculateWidth(users);
        for (int i = 0; i < size; i++) {
            floors.add(new Floor(width));
        }
    }

    private int calculateWidth(Users users) {
        return users.getUsers().size() - DIFFERENCE_BETWEEN_FLOOR_AND_USERS;
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
