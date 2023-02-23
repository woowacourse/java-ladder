package domain;


public class LadderGame {

    private final Ladder ladder;
    private final Users users;
    private final Rewards rewards;

    public LadderGame(Ladder ladder, Users users, Rewards rewards) {
        this.ladder = ladder;
        this.users = users;
        this.rewards = rewards;
    }

    public String findUserReward(int index) {
        return rewards.getReward(index);
    }

    public String findUserReward(String name) {
        int index = users.findUser(name).getPosition();
        return rewards.getReward(index);
    }

}
