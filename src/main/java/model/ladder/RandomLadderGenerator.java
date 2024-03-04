package model.ladder;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import model.bridge.Bridge;
import model.line.Line;

public class RandomLadderGenerator {

    private static final int UNCONNECTED = 0;
    private static final int CONNECTED = 1;

    public static Ladder generateLadder(LadderHeight height, LadderWidth width) {
        return IntStream.range(0, height.getValue())
            .mapToObj(i -> generateLine(width))
            .collect(collectingAndThen(toList(), Ladder::new));
    }

    private static Line generateLine(LadderWidth width) {
        return IntStream.range(0, width.getValue())
            .mapToObj(i -> generateBridge())
            .collect(collectingAndThen(toList(), Line::of));
    }

    private static Bridge generateBridge() {
        int bridge = Randoms.pickNumberInRange(UNCONNECTED, CONNECTED);
        if (bridge == CONNECTED) {
            return Bridge.CONNECTED;
        }
        return Bridge.UNCONNECTED;
    }
}
