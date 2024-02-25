package laddergame.domain.strategy;

import java.util.*;

import laddergame.domain.Zone;
import laddergame.util.ZoneGenerator;
import laddergame.util.RandomZoneGenerator;

public class RandomNoTrueSequenceBuildStrategy implements LineBuildStrategy {
    private final ZoneGenerator generator = RandomZoneGenerator.getGenerator();

    @Override
    public List<Zone> apply(final int count) {
        Stack<Zone> lineStatus = new Stack<>();

        lineStatus.push(generator.generate());
        for (int i = 0; i < count - 1; i ++) {
            lineStatus.push(decideNextValue(lineStatus.peek()));
        }
        return lineStatus.stream().toList();
    }

    private Zone decideNextValue(Zone beforeValue) {
        if (beforeValue.equals(Zone.BRIDGE)) {
            return Zone.EMPTY;
        }
        return generator.generate();
    }
}
