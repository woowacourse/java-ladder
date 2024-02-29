package domain;

import java.util.Map;
import java.util.stream.Collectors;
import strategy.ConnectStrategy;

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
        ConnectStrategy connectStrategy) {

        return new Game(members, Lines.of(members.getCount(), height, connectStrategy), rewards);
    }

    public Map<String, String> findRewardMap() {
        return members.getNames()
            .stream()
            .collect(Collectors.toMap(name -> name, this::findRewardName));
    }

    private String findRewardName(String memberName) {
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
