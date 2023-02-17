package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final static int DIFFERENCE_BETWEEN_FLOOR_AND_USERS = 1;
    private static final int MINIMUM_HEIGHT = 1;
    private static final String LADDER_SIZE_ERROR_MESSAGE = "사다리의 높이는 1이상 입니다.";

    private final List<Floor> floors = new ArrayList<>();

    public Ladder(int height, Users users) {

        validateSize(height);
        int width = calculateWidth(users);
        for (int i = 0; i < height; i++) {
            floors.add(new Floor(width));
        }
    }

    private int calculateWidth(Users users) {
        return users.getUsers().size() - DIFFERENCE_BETWEEN_FLOOR_AND_USERS;
    }

    public void makeFloors(LineGenerator lineGenerator) {

        for (Floor floor : floors) {
            floor.makeFloor(
                    generateFloorNumbers(lineGenerator, floor)
            );
        }
    }

    private List<Boolean> generateFloorNumbers(LineGenerator lineGenerator, Floor floor) {

        List<Boolean> values = new ArrayList<>();
        for (int i = 0; i < floor.getLines().size(); i++) {
            values.add(lineGenerator.generate());
        }
        return values;
    }


    private void validateSize(int height) {

        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(LADDER_SIZE_ERROR_MESSAGE);
        }
    }

    public List<Floor> getFloors() {
        return Collections.unmodifiableList(floors);
    }
}
