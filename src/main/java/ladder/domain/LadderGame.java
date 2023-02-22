package ladder.domain;

import ladder.dto.BridgeGameResult;

public class LadderGame {
    private final Ladder ladder;
    private final Users users;
    private final Reward reward;

    public LadderGame(Ladder ladder, Users users, Reward reward) {
        validateLength(ladder, users, reward);
        this.ladder = ladder;
        this.users = users;
        this.reward = reward;
    }

    private void validateLength(final Ladder ladder, final Users users, final Reward reward) {
        if (!((ladder.getWidth() == users.size()) && (users.size() == reward.size()))) {
            throw new IllegalArgumentException("사다리, 보상, 유저 수의 크기는 같아야 합니다.");
        }
    }

    public String getRewardOf(final String userName) {
        final int userOrder = users.getOrderOf(userName);
        return reward.getRewardOf(ladder.resultPositionOf(userOrder));
    }

    public BridgeGameResult getGameResult() {
        final BridgeGameResult bridgeGameResult = new BridgeGameResult();
        for (User user : users.getUsers()) {
            final String name = user.getName();
            final int rewardIndex = ladder.resultPositionOf(users.getOrderOf(name));
            bridgeGameResult.enrollReward(user, reward.getRewardOf(rewardIndex));
        }
        return bridgeGameResult;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Users getUsers() {
        return users;
    }

    public Reward getReward() {
        return reward;
    }
}
