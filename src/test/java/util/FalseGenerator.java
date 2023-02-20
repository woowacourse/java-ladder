package util;

import domain.Bridge;

public class FalseGenerator implements BridgeGenerator {
    @Override
    public Bridge generate() {
        return Bridge.EMPTY;
    }
}
