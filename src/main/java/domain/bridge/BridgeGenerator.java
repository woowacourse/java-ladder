package domain.bridge;

import domain.LadderBridge;
import java.util.List;

public interface BridgeGenerator {
    List<LadderBridge> generate(int count);
}
