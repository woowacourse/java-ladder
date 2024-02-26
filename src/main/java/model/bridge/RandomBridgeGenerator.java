package model.bridge;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class RandomBridgeGenerator {
    private static final int UNCONNECTED = 0;
    private static final int CONNECTED = 1;

    private RandomBridgeGenerator() {
    }

    public static List<Bridge> generateBridges(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> getRandomBridge())
                .collect(toList());
    }

    private static Bridge getRandomBridge() {
        int bridge = Randoms.pickNumberInRange(UNCONNECTED, CONNECTED);
        if (bridge == CONNECTED) {
            return Bridge.CONNECTED;
        }
        return Bridge.UNCONNECTED;
    }
}
