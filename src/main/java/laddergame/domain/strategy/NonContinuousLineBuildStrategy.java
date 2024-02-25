package laddergame.domain.strategy;

import laddergame.domain.Zone;
import laddergame.util.RandomZoneGenerator;
import laddergame.util.ZoneGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class NonContinuousLineBuildStrategy implements LineBuildStrategy {
    private final ZoneGenerator zoneGenerator;

    public NonContinuousLineBuildStrategy(ZoneGenerator zoneGenerator) {
        this.zoneGenerator = zoneGenerator;
    }

    @Override
    public List<Zone> apply(final int width) {
        List<Zone> lineStatus = new ArrayList<>();

        lineStatus.add(zoneGenerator.generate());
        for (int i = 0; i < width - 1; i++) {
            Zone beforeValue = lineStatus.get(lineStatus.size() -1);
            lineStatus.add(decideNextValue(beforeValue));
        }
        return lineStatus;
    }

    private Zone decideNextValue(Zone beforeValue) {
        if (beforeValue.equals(Zone.BRIDGE)) {
            return Zone.EMPTY;
        }
        return zoneGenerator.generate();
    }
}

