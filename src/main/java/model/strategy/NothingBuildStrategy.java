package model.strategy;

import java.util.ArrayList;
import java.util.List;
import model.LadderStatus;

public class NothingBuildStrategy implements BuildStrategy<LadderStatus> {

    @Override
    public List<LadderStatus> generate(final int size) {
        List<LadderStatus> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(LadderStatus.UNCONNECTED);
        }
        return result;
    }
}
