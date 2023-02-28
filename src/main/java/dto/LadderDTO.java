package dto;

import java.util.List;

public class LadderDTO {
    private final List<LineDTO> ladderDTO;

    public LadderDTO(final List<LineDTO> ladderDTO) {
        this.ladderDTO = ladderDTO;
    }

    public List<LineDTO> getLadderDTO() {
        return ladderDTO;
    }
}
