package laddergame.domain.strategy;

import java.util.ArrayList;
import java.util.List;
import laddergame.dto.LineBuildResult;
import laddergame.util.BooleanGenerator;
import laddergame.util.RandomBooleanGenerator;

public class RandomBuildStrategy implements CanBuildStrategy {
    private final BooleanGenerator generator = RandomBooleanGenerator.getGenerator();

    @Override
    public LineBuildResult canBuildBridges(final int count) {
        List<Boolean> list = new ArrayList<>();
        list.add(generator.generate());
        for (int i = 0; i < count - 1; i++) {
            if (list.get(list.size() - 1)) {
                list.add(Boolean.FALSE);
                continue;
            }
            list.add(generator.generate());
        }

        return new LineBuildResult(list.stream().toList());
    }
}
