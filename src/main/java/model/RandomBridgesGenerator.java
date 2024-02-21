package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBridgesGenerator implements BridgesGenerator {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 1;
    private static final String INVALID_BRIDGE_CODE = "유효하지 않은 다리 코드입니다.";

    @Override
    public List<Bridge> pickBridges(int count) {
        List<Bridge> bridges = new ArrayList<>();
        while (bridges.size() < count) {
            int bridgeCode = generateBridgeCode(bridges);
            bridges.add(generateBridge(bridgeCode));
        }
        return bridges;
    }

    private int generateBridgeCode(List<Bridge> bridges) {
        if (isPossibleToMake(bridges)) {
            return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        }
        return 0;
    }

    private Bridge generateBridge(int bridgeCode) {
        return Bridge.findBridgeByCode(bridgeCode)
                .orElseThrow(() -> new IllegalStateException(INVALID_BRIDGE_CODE));
    }

    private boolean isPossibleToMake(List<Bridge> bridges) {
        if (bridges.isEmpty()) {
            return true;
        }
        Bridge lastBridge = bridges.get(bridges.size() - 1);
        return !lastBridge.isConnected();
    }
}
