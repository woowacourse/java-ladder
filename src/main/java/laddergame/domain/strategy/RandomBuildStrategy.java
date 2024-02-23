package laddergame.domain.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import laddergame.dto.LineBuildResult;
import laddergame.util.BooleanGenerator;
import laddergame.util.RandomBooleanGenerator;

public class RandomBuildStrategy implements CanBuildStrategy {
    private final BooleanGenerator generator = RandomBooleanGenerator.getGenerator();

    @Override
    public LineBuildResult canBuildBridges(final int count) {
        List<Boolean> list = new ArrayList<>();
        list.add(generator.generate());
        IntStream.range(0, count - 1).forEach(i -> addBuildResult(list));

        return new LineBuildResult(list.stream().toList());
    }

    private void addBuildResult(List<Boolean> list) {
        if (list.get(list.size() - 1)) {
            list.add(true);
            return;
        }
        list.add(generator.generate());
    }
}
