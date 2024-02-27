package domain;

import strategy.PointStrategy;

public class Game {

    private final Members members;
    private final Lines lines;
    private final Rewards rewards;

    private Game(Members members, Lines lines, Rewards rewards) {
        this.members = members;
        this.lines = lines;
        this.rewards = rewards;
    }

    public static Game of(
        Members members,
        Height height,
        Rewards rewards,
        PointStrategy pointStrategy) {

        return new Game(members, Lines.of(members.getCount(), height, pointStrategy), rewards);
    }

    public String findRewardNameByMemberName(String memberName) {
        int memberIndex = members.findIndexByName(memberName);
        int rewardIndex = lines.findRewardIndex(memberIndex);
        return rewards.findRewardNameByIndex(rewardIndex);
    }

    public Members getMembers() {
        return members;
    }

    public Lines getLines() {
        return lines;
    }

    public Rewards getRewards() {
        return rewards;
    }
}
