package model.strategy;

import java.util.ArrayList;
import java.util.List;
import model.Step;

public class ZigZagStartFalseBuildStrategy implements BuildStrategy<Step> {

    @Override
    public List<Step> generate(final int size) {
        List<Step> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(generateStep(i));
        }
        return result;
    }

    private Step generateStep(final int index) {
        if (index % 2 == 0) {
            return new Step(false);
        }
        return new Step(true);
    }
}
