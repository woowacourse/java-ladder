package laddergame.domain.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import laddergame.util.BooleanGenerator;
import laddergame.util.RandomBooleanGenerator;

public class RandomBuildStrategy implements LineBuildStrategy {
    private final BooleanGenerator generator = RandomBooleanGenerator.getGenerator();

    @Override
    public List<Boolean> apply(final int count) {
        List<Boolean> list = new ArrayList<>();
        list.add(generator.generate());
        IntStream.range(0, count - 1).forEach(i -> addBuildResult(list));

        return list;
    }

    private void addBuildResult(List<Boolean> list) {
        if (list.get(list.size() - 1)) {
            list.add(false);
            return;
        }
        list.add(generator.generate());
    }
}
