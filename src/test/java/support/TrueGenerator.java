package support;

import domain.booleanGenerator.BooleanGenerator;
import domain.ladder.LadderRung;

public class TrueGenerator implements BooleanGenerator {
    @Override
    public boolean generate() {
        return LadderRung.CONNECTED.isConnected();
    }
}
