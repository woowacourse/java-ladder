package view;

import domain.ladder.Bridge;
import java.util.Arrays;
import java.util.List;

public enum BridgeShape {

    BRIDGE("-----", Bridge.EXIST),
    NO_BRIDGE("     ", Bridge.NOT_EXIST);

    private static final int ONLY_ONE_FOUND = 1;

    private final String shape;
    private final Bridge bridge;

    BridgeShape(final String shape, final Bridge bridge) {
        this.shape = shape;
        this.bridge = bridge;
    }

    public static String convertForView(Bridge bridge) {
        final List<BridgeShape> matchedBridgeShape = Arrays.stream(values())
                .filter(bridgeShape -> bridgeShape.bridge == bridge)
                .toList();

        if (matchedBridgeShape.size() != ONLY_ONE_FOUND) {
            throw new IllegalStateException("BridgeShape을 찾을 수 없거나 중복되는 값이 존재합니다.");
        }

        return matchedBridgeShape.get(0).shape;
    }
}
