package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.dto.FloorResponseDto;
import ladder.domain.dto.LadderResponseDto;
import ladder.domain.randomGenerator.RungGenerator;

public class Ladder {

    private final List<Floor> floors;

    public Ladder(Height height, int personCount, RungGenerator rungGenerator) {
        floors = makeFloors(height, personCount, rungGenerator);
    }

    private List<Floor> makeFloors(Height height, int personCount, RungGenerator rungGenerator) {
        return IntStream.range(0, height.getHeight())
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
