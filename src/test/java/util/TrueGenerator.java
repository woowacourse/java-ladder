package util;

import domain.Bridge;

public class TrueGenerator implements BridgeGenerator {
    @Override
    public Bridge generate() {
        return Bridge.EXIST;
    }
}
