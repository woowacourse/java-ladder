package domain.generator;

import domain.Bridge;

public class FixedBridgeGenerator implements BridgeGenerator {

    @Override
    public Bridge generate(Bridge bridge) {
        if (!bridge.isExist()) {
            return Bridge.EXIST;
        }
        return Bridge.BLANK;
    }
}
