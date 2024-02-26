package model.strategy;

import java.util.ArrayList;
import java.util.List;
import model.Step;

//TODO: 인터페이스가 너무 이상함 List<Step>을 만드는게 아니라 List<List<Step>> 고려
public class ZigZagStartTrueBuildStrategy implements BuildStrategy<Step> {

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
            return new Step(true);
        }
        return new Step(false);
    }
}
