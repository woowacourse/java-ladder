package model.strategy;

import java.util.ArrayList;
import java.util.List;
import model.Step;

public class NothingBuildStrategy implements BuildStrategy<Step> {

    @Override
    public List<Step> generate(final int size) {
        List<Step> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Step(false));
        }
        return result;
    }
}
