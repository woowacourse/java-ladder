package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> bridges;

    private Line(List<Boolean> bridges) {
        this.bridges = bridges;
    }
    public static Line createByStrategy(final BridgeGenerator bridgeGenerator, final int personCount) {
        List<Boolean> bridges = new ArrayList<>();
        while (bridges.size() != personCount - 1) {
            final boolean bridgeCandidate = bridgeGenerator.generate();
            final boolean previousBridge = findPreviousBridge(bridges);

            bridges.add(createBridge(bridgeCandidate, previousBridge));
        }
        return new Line(bridges);
    }

    private static boolean findPreviousBridge(List<Boolean> bridges) {
        if (bridges.size() == 0) {
            return false;
        }
        return bridges.get(bridges.size() - 1);
    }

    private static boolean createBridge(final boolean bridgeCandidate, final boolean previousBridge) {
        if (!bridgeCandidate) {
            return bridgeCandidate;
        }
        if (previousBridge == false) {
            return bridgeCandidate;
        }
        return false;
    }


    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(bridges);
    }

}
