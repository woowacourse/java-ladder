package ladder.domain;

import ladder.dto.BridgeGameResult;

import java.util.HashMap;

public class LadderGame {
    private static final String INVALID_BRIDGE_GAME_SIZE_ERROR_MESSAGE = "사다리, 보상, 유저 수의 크기는 같아야 합니다.";

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
        if (!sameSize(ladder, users, reward)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_GAME_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean sameSize(final Ladder ladder, final Users users, final Reward reward) {
        final boolean sameSizeForLadderAndUsers = isSameSize(ladder.getWidth(), users.size());
        final boolean sameSizeForUsersAndReward = isSameSize(users.size(), reward.size());
        return sameSizeForLadderAndUsers && sameSizeForUsersAndReward;
    }

    private boolean isSameSize(final int size1, final int size2) {
        return size1 == size2;
    }

    public String getRewardOf(final String userName) {
        final int userOrder = users.getOrderByName(userName);
        return reward.getRewardOf(ladder.resultPositionOf(userOrder));
    }

    public BridgeGameResult getGameResult() {
        final HashMap<User, String> userAndReward = new HashMap<>();
        for (User user : users.getUsers()) {
            final int rewardIndex = ladder.resultPositionOf(users.getOrderByName(user.getName()));
            userAndReward.put(user, reward.getRewardOf(rewardIndex));
        }
        return new BridgeGameResult(userAndReward);
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
