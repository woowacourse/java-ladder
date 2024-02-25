package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BridgeRandomGenerator implements BridgeGenerator {
    public List<Boolean> generate(int width) {
        Random random = new Random();
        List<Boolean> rowInfos = generateBridges(width, random);
        fixRowInfo(width, rowInfos);
        return rowInfos;
    }

    private List<Boolean> generateBridges(int width, Random random) {
        return IntStream.range(0, width)
                .mapToObj(value -> random.nextBoolean())
                .collect(Collectors.toList());
    }

    private void fixRowInfo(int width, List<Boolean> rowInfos) {
        for (int index = 1; index < width; index++) {
            fixIfNeed(rowInfos, index);
        }
    }

    private void fixIfNeed(List<Boolean> rowInfos, int index) {
        if (isBridgeInARow(rowInfos, index)) {
            rowInfos.set(index, false);
        }
    }

    private boolean isBridgeInARow(List<Boolean> rowInfos, int index) {
        return rowInfos.get(index) && rowInfos.get(index - 1);
    }
}
