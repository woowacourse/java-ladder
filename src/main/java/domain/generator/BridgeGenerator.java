package domain.generator;

import domain.Bridge;

public interface BridgeGenerator {

    Bridge generate(Bridge previous);
}
