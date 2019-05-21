package ladder.domain.ladder;

import ladder.domain.rule.LadderRule;

public class ForcedRule implements LadderRule {
    private int num = 0;

    @Override
    public boolean isAvailablePoint() {
        num++;
        return num != 5;
    }
}
