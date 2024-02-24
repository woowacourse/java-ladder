package laddergame.domain.strategy;

import java.util.*;

import laddergame.util.BooleanGenerator;
import laddergame.util.RandomBooleanGenerator;

public class RandomNoTrueSequenceBuildStrategy implements LineBuildStrategy {
    private final BooleanGenerator generator = RandomBooleanGenerator.getGenerator();

    @Override
    public List<Boolean> apply(final int count) {
        Stack<Boolean> lineStatus = new Stack<>();

        lineStatus.push(generator.generate());
        for (int i = 0; i < count - 1; i ++) {
            lineStatus.push(decideNextValue(lineStatus.peek()));
        }
        return lineStatus.stream().toList();
    }

    private Boolean decideNextValue(Boolean beforeValue) {
        if (beforeValue) {
            return false;
        }
        return generator.generate();
    }
}
