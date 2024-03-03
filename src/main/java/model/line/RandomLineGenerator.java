package model.line;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import model.bridge.Bridge;

public class RandomLineGenerator implements LineGenerator {

    private static final int UNCONNECTED = 0;
    private static final int CONNECTED = 1;

    @Override
    public Line generateLine(int width) {
        return IntStream.range(0, width)
            .mapToObj(i -> generateRandomBridge())
            .collect(collectingAndThen(toList(), Line::new));
    }

    private Bridge generateRandomBridge() {
        int bridge = Randoms.pickNumberInRange(UNCONNECTED, CONNECTED);
        if (bridge == CONNECTED) {
            return Bridge.CONNECTED;
        }
        return Bridge.UNCONNECTED;
    }
}
