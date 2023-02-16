package dto;

import domain.Ladder;
import domain.Names;

import java.util.List;

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

    public List<String> getNames(){
        return namesDto.getNames();
    }

    public int getMaxNameLength(){
        return this.namesDto.getMaxNameLength();
    }

    public List<List<Boolean>> getGeneratedLadderInfo(){
        return this.ladderDto.getLadderInfo();
    }
}
