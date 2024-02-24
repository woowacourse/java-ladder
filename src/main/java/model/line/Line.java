package model.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.bridge.Bridge;

public final class Line {
    private static final String INVALID_BRIDGE_CODE = "유효하지 않은 다리 코드입니다.";

    private final List<Bridge> bridges;

    private Line(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Line from(List<Integer> binaryNumbers) {
        List<Bridge> bridges = new ArrayList<>();
        for (int binaryNumber : binaryNumbers) {
            bridges.add(generateBridge(binaryNumber, bridges));
        }
        return new Line(bridges);
    }

    private static Bridge generateBridge(int binaryNumber, List<Bridge> bridges) {
        if (bridges.isEmpty() || getLastBridge(bridges).isUnconnected()) {
            return getBridgeByCodeOrThrow(binaryNumber);
        }
        return Bridge.UNCONNECTED;
    }

    private static Bridge getLastBridge(List<Bridge> bridges) {
        return bridges.get(bridges.size() - 1);
    }

    private static Bridge getBridgeByCodeOrThrow(int bridgeCode) {
        return Bridge.findBridgeByCode(bridgeCode)
                .orElseThrow(() -> new IllegalStateException(INVALID_BRIDGE_CODE));
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
