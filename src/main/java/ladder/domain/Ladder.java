package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 0;
    private static final int MINIMUM_WIDTH = 2;
    private static final String LADDER_HEIGHT_ERROR_MESSAGE = "사다리의 높이는 1이상 입니다.";
    private static final String LADDER_WIDTH_ERROR_MESSAGE = "사다리 가로 크기는 2 이상입니다.";
    private static final int DIFFERENCE_BETWEEN_WIDTH_AND_LINE = 1;

    private final List<Floor> floors = new ArrayList<>();

    public Ladder(int height, int width) {
        validateSize(height, width);
        final int lineCount = width - DIFFERENCE_BETWEEN_WIDTH_AND_LINE;
        makeLadder(height, lineCount);
    }

    private void validateSize(final int height, final int width) {
        validateHeight(height);
        validateWidth(width);
    }

    private void validateHeight(int size) {
        if (size <= MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(LADDER_HEIGHT_ERROR_MESSAGE);
        }
    }

    private void validateWidth(final int width) {
        if (width < MINIMUM_WIDTH) {
            throw new IllegalArgumentException(LADDER_WIDTH_ERROR_MESSAGE);
        }
    }

    private void makeLadder(final int height, final int lineCount) {
        for (int i = 0; i < height; i++) {
            floors.add(new Floor(lineCount));
        }
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

    public int resultPositionOf(final int startPosition) {
        int position = startPosition;
        for (Floor floor : floors) {
            position = floor.getResultPosition(position);
        }
        return position;
    }

    public int getWidth() {
        return floors.get(0).getSizeOfLineEdge();
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
