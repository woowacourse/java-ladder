package model.line;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import model.bridge.Bridge;

public class RandomLineGenerator implements LineGenerator {
    @Override
    public Line generateLine(int width) {
        return IntStream.range(0, width)
                .mapToObj(i -> getRandomBridge())
                .collect(collectingAndThen(toList(), Line::new));
    }

    private static Bridge getRandomBridge() {
        int bridge = Randoms.pickNumberInRange(UNCONNECTED, CONNECTED);
        if (bridge == CONNECTED) {
            return Bridge.CONNECTED;
        }
        return Bridge.UNCONNECTED;
    }
}
