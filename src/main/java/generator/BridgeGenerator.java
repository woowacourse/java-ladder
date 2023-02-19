package generator;

import domain.BridgeStatus;

@FunctionalInterface
public interface BridgeGenerator {

    BridgeStatus generate();
}
