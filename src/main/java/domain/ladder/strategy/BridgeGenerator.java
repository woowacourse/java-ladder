package domain.ladder.strategy;

import domain.ladder.LadderBridge;
import java.util.List;

public interface BridgeGenerator {
    List<LadderBridge> generate(final int count);
}
