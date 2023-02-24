package dto;

import model.GameResult;

public class GameResultDto {

    private final String participantName;
    private final String ladderResult;

    public GameResultDto(GameResult gameResult) {
        this.participantName = gameResult.getName();
        this.ladderResult = gameResult.getLadderResult();
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getLadderResult() {
        return ladderResult;
    }
}
