package dto;

public class GameDto {
    private final NamesDto namesDto;
    private final LadderDto ladderDto;

    public GameDto(NamesDto namesDto, LadderDto ladderDto) {
        this.namesDto = namesDto;
        this.ladderDto = ladderDto;
    }

    public LadderDto getLadderDto() {
        return ladderDto;
    }

    public NamesDto getNamesDto() {
        return namesDto;
    }
}
