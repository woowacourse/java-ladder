package ladder.domain;

public class LadderGame {
    private final Ladder ladder;
    private final Users users;
    private final Reward reward;

    public LadderGame(Ladder ladder, Users users, Reward reward) {
        this.ladder = ladder;
        this.users = users;
        this.reward = reward;
    }

    public String getRewardOf(final String userName) {
        final int userOrder = users.getOrderOf(userName);
        return reward.getRewardOf(ladder.resultPositionOf(userOrder));
    }
}
