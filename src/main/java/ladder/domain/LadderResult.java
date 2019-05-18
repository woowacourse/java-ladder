package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    public static List<String> generate(List<Integer> result, List<String> items) {
        List<String> finalResult = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            finalResult.add(items.get(result.get(i)));
        }

        return finalResult;
    }
}
