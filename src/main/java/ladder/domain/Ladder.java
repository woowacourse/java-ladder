package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.dto.FloorResponseDto;
import ladder.domain.dto.LadderResponseDto;
import ladder.domain.randomGenerator.RungGenerator;

public class Ladder {

    private static final int MIN_HEIGHT_RANGE = 1;
    private static final int MAX_HEIGHT_RANGE = 100;

    private final List<Floor> floors;

    public Ladder(int height, int personCount, RungGenerator rungGenerator) {
        validateHeightRange(height);
        floors = makeFloors(height, personCount, rungGenerator);
    }

    private void validateHeightRange(int height) {
        if (height < MIN_HEIGHT_RANGE || MAX_HEIGHT_RANGE < height) {
            throw new IllegalArgumentException(
                    "입력된 높이는 " + MIN_HEIGHT_RANGE + " 이상,"
                            + " " + MAX_HEIGHT_RANGE + " 이하여야 합니다. 입력값 : " + height);
        }
    }

    private List<Floor> makeFloors(int height, int personCount, RungGenerator rungGenerator) {
        return IntStream.range(0, height)
                .mapToObj(currentHeight -> new Floor(rungGenerator, personCount))
                .toList();
    }

    public LadderResponseDto getResultLadders() {
        List<FloorResponseDto> floorResponseDtos = floors.stream()
                .map(Floor::getRungs)
                .toList();

        return new LadderResponseDto(floorResponseDtos);
    }
}
