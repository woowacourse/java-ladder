package dto;

import java.util.List;

public class LadderDto {
    private final List<List<Boolean>> ladderInfo;

    public LadderDto(List<List<Boolean>> ladderInfo) {
        this.ladderInfo = ladderInfo;
    }

    public List<List<Boolean>> getLadderInfo() {
        return ladderInfo;
    }
}
