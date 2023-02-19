package ladder.domain;

import ladder.domain.generator.PointGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final static int DIFFERENCE_BETWEEN_FLOOR_AND_USERS = 1;
    private static final int MINIMUM_HEIGHT = 1;
    private static final String LADDER_SIZE_ERROR_MESSAGE = "사다리의 높이는 " + MINIMUM_HEIGHT + " 이상 입니다.";

    private final List<Floor> floors;

    public Ladder(int height, Users users, PointGenerator pointGenerator) {

        validateSize(height);
        int width = calculateWidth(users);

        this.floors = generateFloors(height, pointGenerator, width);
    }

    private void validateSize(int height) {

        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(LADDER_SIZE_ERROR_MESSAGE);
        }
    }

    private int calculateWidth(Users users) {
        return users.getUsers().size() - DIFFERENCE_BETWEEN_FLOOR_AND_USERS;
    }

    private List<Floor> generateFloors(int height, PointGenerator pointGenerator, int width) {
        return Stream.generate(
                        () -> new Floor(generateValues(pointGenerator, width))
                )
                .limit(height)
                .collect(Collectors.toList());
    }

    private List<Point> generateValues(PointGenerator pointGenerator, int width) {
        return Stream.generate(pointGenerator::generate)
                .map(Point::of)
                .limit(width)
                .collect(Collectors.toList());
    }

    public List<Floor> getFloors() {
        return Collections.unmodifiableList(floors);
    }
}
