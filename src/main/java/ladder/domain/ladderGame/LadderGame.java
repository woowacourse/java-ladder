package ladder.domain.ladderGame;

import ladder.domain.carpenter.Carpenter;
import ladder.domain.dto.MadeLadderDto;
import ladder.domain.participant.Participants;

public class LadderGame {

    private final Carpenter carpenter;
    private final Participants participants;

    public LadderGame(Carpenter carpenter, Participants participants) {
        this.carpenter = carpenter;
        this.participants = participants;
    }

    public MadeLadderDto play(int totalLadderCount) {
        carpenter.buildLadders(totalLadderCount);
        return carpenter.getResultLadders();
    }
}
