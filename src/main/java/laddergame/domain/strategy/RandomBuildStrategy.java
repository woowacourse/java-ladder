package laddergame.domain.strategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import laddergame.util.BooleanGenerator;
import laddergame.util.RandomBooleanGenerator;

public class RandomBuildStrategy implements CanBuildStrategy {
    private final BooleanGenerator generator = RandomBooleanGenerator.getGenerator();

    @Override
    public List<Boolean> canBuildBridges(final int count) {
        Queue<Boolean> list = new LinkedList<>();

        for (int i = 0; i < count; i++){
            if (Boolean.TRUE.equals(list.peek())) {
                list.add(Boolean.FALSE);
                continue;
            }
            list.add(generator.generate());
        }

        return list.stream().toList();
    }
}
