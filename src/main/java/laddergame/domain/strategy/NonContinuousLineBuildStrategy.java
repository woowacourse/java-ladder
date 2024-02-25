package laddergame.domain.strategy;

import laddergame.domain.Zone;
import laddergame.util.RandomZoneGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class NonContinuousLineBuildStrategy implements LineBuildStrategy {
    @Override
    public List<Zone> apply(final int count) {
        List<Zone> lineStatus = new ArrayList<>();

        lineStatus.add(new RandomZoneGenerator().generate());
        for (int i = 0; i < count - 1; i++) {
            Zone beforeValue = lineStatus.get(lineStatus.size() -1);
            lineStatus.add(decideNextValue(beforeValue));
        }
        return lineStatus;
    }

    private Zone decideNextValue(Zone beforeValue) {
        if (beforeValue.equals(Zone.BRIDGE)) {
            return Zone.EMPTY;
        }
        return new RandomZoneGenerator().generate();
    }
}
