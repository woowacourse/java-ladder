package dto;

import domain.Ladder;
import domain.Names;

public class GameDto {
    private final NamesDto namesDto;
    private final LadderDto ladderDto;

    public GameDto(Names names, Ladder ladder) {
        this.namesDto = makeNameDTO(names);
        this.ladderDto = makeLadderDTO(ladder);
    }

    private NamesDto makeNameDTO(Names names){
        return NamesDto.from(names);
    }

    private LadderDto makeLadderDTO(Ladder ladder){
        return LadderDto.from(ladder);
    }

    public LadderDto getLadderDto() {
        return ladderDto;
    }

    public NamesDto getNamesDto() {
        return namesDto;
    }
}
