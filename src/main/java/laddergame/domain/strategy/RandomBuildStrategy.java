package laddergame.domain.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import laddergame.util.BooleanGenerator;
import laddergame.util.RandomBooleanGenerator;

public class RandomBuildStrategy implements CanBuildStrategy {
    private final BooleanGenerator generator = RandomBooleanGenerator.getGenerator();

    @Override
    public List<Boolean> canBuildBridges(final int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generator.generate())
                .collect(Collectors.toList());
    }
}
