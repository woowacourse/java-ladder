package model.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.LadderStatus;

public class RandomBuildStrategy implements BuildStrategy<LadderStatus> {

    private static final Random random = new Random();

    @Override
    public List<LadderStatus> generate(int size) {
        List<LadderStatus> ladderStatuses = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ladderStatuses.add(generateStep(ladderStatuses, i));
        }
        return ladderStatuses;
    }

    private LadderStatus generateStep(List<LadderStatus> points, int index) {
        if (cannotConnect(points, index)) {
            return LadderStatus.UNCONNECTED;
        }
        return LadderStatus.from(random.nextBoolean());
    }

    private boolean cannotConnect(List<LadderStatus> points, int index) {
        return index >= 1 && points.get(index - 1).isConnected();
    }
}
