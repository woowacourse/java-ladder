package domain.point;

import domain.LadderBridge;

import java.util.List;

public interface BridgeGenerator {
    List<LadderBridge> generate(int count);
}
