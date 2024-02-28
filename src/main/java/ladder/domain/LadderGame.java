package ladder.domain;

import ladder.domain.dto.ResultLadderDto;
import ladder.domain.dto.ResultStepLadderDto;

public class LadderGame {

    private final Carpenter carpenter;
    private final Participants participants;

    public LadderGame(Carpenter carpenter, Participants participants) {
        this.carpenter = carpenter;
        this.participants = participants;
    }

    public ResultLadderDto play(int totalLadderCount) {
        carpenter.buildLadders(totalLadderCount);
        return carpenter.getResultLadders();
    }

    public LadderResult mapLadderGame(ResultStepLadderDto resultStepLadderDto) {
        return new LadderResult(resultStepLadderDto, participants.getParticipantsCount());
    }
}
