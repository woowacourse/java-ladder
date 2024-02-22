package support;

import domain.ladder.LadderRung;
import domain.ladder.LadderRungGenerator;

public class ConnectedLadderRungGenerator implements LadderRungGenerator {
    @Override
    public LadderRung generate() {
        return LadderRung.CONNECTED;
    }
}
