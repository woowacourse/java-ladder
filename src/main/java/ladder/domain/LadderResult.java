package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    public static List<Item> generate(List<Integer> result, Items items) {
        List<Item> finalResult = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            finalResult.add(items.getItem(result.get(i)));
        }

        return finalResult;
    }
}
