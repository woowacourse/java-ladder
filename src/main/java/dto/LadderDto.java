package dto;

import domain.Ladder;

import java.util.List;

public class LadderDto {
    private final List<List<Boolean>> ladderInfo;

    private LadderDto(List<List<Boolean>> ladderInfo) {
        this.ladderInfo = ladderInfo;
    }

    public static LadderDto from(Ladder ladder){
        return new LadderDto((ladder.getValue()));
    }

    public List<List<Boolean>> getLadderInfo() {
        return ladderInfo;
    }
}
