package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    public static List<String> match(List<String> items, List<Integer> result) {
        List<String> ladderResult = new ArrayList<>();

        for (int index : result) {
            ladderResult.add(items.get(index));
        }

        return ladderResult;
    }
}
