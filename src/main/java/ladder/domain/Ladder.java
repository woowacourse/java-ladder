package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final static int DIFFERENCE_BETWEEN_FLOOR_AND_USERS = 1;
    private static final int MINIMUM_SIZE = 0;
    private static final String LADDER_SIZE_ERROR_MESSAGE = "사다리의 높이는 1이상 입니다.";
    private final List<Floor> floors = new ArrayList<>();

    public Ladder(int height, Users users) {
        validateHeight(height);
        makeLadder(height, calculateWidth(users));
    }

    private void validateHeight(int size) {
        if (size <= MINIMUM_SIZE) {
            throw new IllegalArgumentException(LADDER_SIZE_ERROR_MESSAGE);
        }
    }

    private void makeLadder(final int height, final int width) {
        for (int i = 0; i < height; i++) {
            floors.add(new Floor(width));
        }
    }

    private int calculateWidth(Users users) {
        return users.size() - DIFFERENCE_BETWEEN_FLOOR_AND_USERS;
    }

    public void makeFloors(LineSourceGenerator lineSourceGenerator) {
        for (Floor floor : floors) {
            floor.makeFloor(
                    generateFloorLineSources(lineSourceGenerator, floor)
            );
        }
    }

    private List<LineSource> generateFloorLineSources(LineSourceGenerator lineSourceGenerator, Floor floor) {
        List<LineSource> numbers = new ArrayList<>();
        for (int i = 0; i < floor.getLines().size(); i++) {
            numbers.add(lineSourceGenerator.generate());
        }
        return numbers;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public int resultPositionOf(final int i) {
        int position = i;
        for(Floor floor : floors){
            position = floor.getResultPosition(position);
        }
        return position;
    }
}
