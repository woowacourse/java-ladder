package ladder.domain;

import java.util.Arrays;
import java.util.List;

public class LadderResult {
    List<String> rewards;

    public LadderResult(String text) {
        rewards = Arrays.asList(text.split(","));
    }

    public List<String> reward() {
        return rewards;
    }

    public String run(Ladder ladder, int index) {
        List<LadderRow> rows = ladder.status();
        for (int j = 0; j < rows.size(); j++) {
            index += rows.get(j).status().get(index);
        }
        return rewards.get(index);
    }
}
