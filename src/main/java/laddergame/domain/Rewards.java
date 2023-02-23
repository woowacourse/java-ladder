package laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Rewards {
    private static final String FAIL_MESSAGE = "꽝";
    
    List<String> rewards;

    public Rewards(List<String> rewards) {
        checkNotFailMessageOrNotDigit(rewards);
        this.rewards = rewards;
    }

    public List<String> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    private void checkNotFailMessageOrNotDigit(List<String> rewards) {
        if (rewards.stream()
                .filter(e -> (!e.equals(FAIL_MESSAGE) && !e.chars().allMatch(Character::isDigit))).count() != 0) {
            throw new IllegalArgumentException("reward 목록은 '꽝' 이나 숫자만 입력 가능합니다.");
        }
    }
}
