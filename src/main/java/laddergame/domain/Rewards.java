package laddergame.domain;

import java.util.List;

public class Rewards {
    private static final String FAIL_MESSAGE = "꽝";
    List<String> rewards;

    public Rewards(List<String> rewards) {
        checknull(rewards);
        checkBlank(rewards);
        checkNotFailMessageOrNotDigit(rewards);
        this.rewards = rewards;
    }

    public void checkRewardsCount(int playerCount) {
        if (rewards.size() != playerCount) {
            throw new IllegalArgumentException("reward 개수는 플레이어의 수와 같아야 합니다.");
        }
    }

    public List<String> getRewards() {
        return rewards;
    }

    private void checknull(List<String> rewards) {
        if (rewards.isEmpty()) {
            throw new IllegalArgumentException("reward 목록을 입력해주세요.");
        }
    }

    private void checkBlank(List<String> rewards) {
        if (rewards.stream().filter(e -> e.isBlank()).count() != 0) {
            throw new IllegalArgumentException("reward 목록에 공백이 입력될 수 없습니다.");
        }
    }

    private void checkNotFailMessageOrNotDigit(List<String> rewards) {
        if (rewards.stream()
                .filter(e -> (!e.equals(FAIL_MESSAGE) && !e.chars().allMatch(Character::isDigit))).count() != 0) {
            throw new IllegalArgumentException("reward 목록은 '꽝' 이나 숫자만 입력 가능합니다.");
        }
    }


}
