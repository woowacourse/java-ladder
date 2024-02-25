package laddergame.domain.strategy;

import laddergame.domain.Zone;
import laddergame.util.RandomZoneGenerator;
import laddergame.util.ZoneGenerator;

import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class RandomNoTrueSequenceBuildStrategy implements LineBuildStrategy {
    private final ZoneGenerator generator = RandomZoneGenerator.getGenerator();

    @Override
    public List<Zone> apply(final int count) {
        Stack<Zone> lineStatus = new Stack<>();
        lineStatus.push(generator.generate());
        IntStream.range(0, count - 1)
                .forEach(i -> lineStatus.push(decideNextValue(lineStatus.peek())));

        return lineStatus.stream().toList();
    }

    private Zone decideNextValue(Zone beforeValue) {
        if (beforeValue.equals(Zone.BRIDGE)) {
            return Zone.EMPTY;
        }
        return generator.generate();
    }
}
