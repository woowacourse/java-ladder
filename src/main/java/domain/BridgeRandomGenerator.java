package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BridgeRandomGenerator implements BridgeGenerator {
    public List<Boolean> generate(int width) {
        Random random = new Random();
        List<Boolean> rowInfos = generateRowInfos(width, random);
        fixRowInfo(width, rowInfos);
        return rowInfos;
    }

    private List<Boolean> generateRowInfos(int width, Random random) {
        return IntStream.range(0, width)
                .mapToObj(value -> random.nextBoolean())
                .collect(Collectors.toList());
    }

    private void fixRowInfo(int width, List<Boolean> rowInfos) {
        IntStream.range(1, width).forEach(
                index -> {
                    if (rowInfos.get(index) && rowInfos.get(index - 1)) {
                        rowInfos.set(index, false);
                    }
                }
        );
    }
}
