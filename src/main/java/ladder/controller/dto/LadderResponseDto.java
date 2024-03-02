package ladder.controller.dto;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.ladder.Floor;
import ladder.domain.ladder.Ladder;

public record LadderResponseDto(List<FloorResponseDto> ladderResult) {

    public static LadderResponseDto from(Ladder ladder) {
        List<FloorResponseDto> floorResponseDtos = new ArrayList<>();

        for (Floor floor : ladder.getFloors()) {
            floorResponseDtos.add(FloorResponseDto.from(floor.getRungs()));
        }

        return new LadderResponseDto(floorResponseDtos);
    }
}
