package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RowInfoGenerator {
    public static List<Boolean> generate(int width) {
        List<Boolean> rowInfos = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < width; i++) {
            rowInfos.add(random.nextBoolean());
        }
        IntStream.range(1, width).forEach(
                index -> {
                    if (rowInfos.get(index) && rowInfos.get(index - 1)) {
                        rowInfos.set(index, false);
                    }
                }
        );
        return rowInfos;
    }
}
