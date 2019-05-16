package ladder.domain;

import java.util.ArrayList;
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
            List<Integer> currentLines = rows.get(j).status();
            index += currentLines.get(index);
        }

        return rewards.get(index);
    }

    public List<String> run(Ladder ladder) {
        List<String> resultAll = new ArrayList<>();
        for (int i = 0; i < rewards.size(); i++) {
            resultAll.add(run(ladder, i));
        }
        return resultAll;
    }
}
