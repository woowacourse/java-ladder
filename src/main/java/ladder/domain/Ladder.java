package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final static int DIFFERENCE_BETWEEN_FLOOR_AND_USERS = 1;
    private static final int MINIMUM_SIZE = 0;
    private static final String LADDER_SIZE_ERROR_MESSAGE = "사다리의 높이는 1이상 입니다.";
    private final List<Floor> floors = new ArrayList<>();

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
        if (size <= MINIMUM_SIZE) {
            throw new IllegalArgumentException(LADDER_SIZE_ERROR_MESSAGE);
        }
    }

}
