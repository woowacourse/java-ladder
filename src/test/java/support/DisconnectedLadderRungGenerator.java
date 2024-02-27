package support;

import domain.ladder.LadderRung;
import domain.ladder.LadderRungGenerator;

public class DisconnectedLadderRungGenerator implements LadderRungGenerator {
    @Override
    public LadderRung generate() {
        return LadderRung.DISCONNECTED;
    }
}
