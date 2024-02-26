package model.strategy;

import java.util.ArrayList;
import java.util.List;
import model.LadderStatus;

//TODO: 인터페이스가 너무 이상함 List<Step>을 만드는게 아니라 List<List<Step>> 고려
public class ZigZagStartTrueBuildStrategy implements BuildStrategy<LadderStatus> {

    @Override
    public List<LadderStatus> generate(final int size) {
        List<LadderStatus> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(generateStep(i));
        }
        return result;
    }

    private LadderStatus generateStep(final int index) {
        return LadderStatus.from(index % 2 == 0);
    }
}
