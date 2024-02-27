package domain.ladderTest;

import domain.Bridge;
import domain.Bridges;
import domain.bridgeConstructstrategy.BridgeConstructStrategy;
import java.util.List;
import java.util.stream.IntStream;

class CheckPatternBridgeConstructStrategy implements BridgeConstructStrategy {
    static int callCount;
    static boolean canBuild;

    public CheckPatternBridgeConstructStrategy() {
        callCount = 0;
        canBuild = true;
    }

    @Override
    public Bridges generate(int count) {
        if (callCount++ % 2 == 0) {
            canBuild = true;
            List<Bridge> bridges = makeBridgesByCount(count);
            return new Bridges(bridges);
        }
        canBuild = false;
        List<Bridge> bridges = makeBridgesByCount(count);
        return new Bridges(bridges);
    }

    private List<Bridge> makeBridgesByCount(int count) {
        return IntStream.range(0, count)
                .mapToObj((i) -> makeBridgeWithSwitch())
                .toList();
    }

    private Bridge makeBridgeWithSwitch() {
        if (canBuild) {
            canBuild = false;
            return Bridge.BUILT;
        }
        canBuild = true;
        return Bridge.EMPTY;
    }
}
