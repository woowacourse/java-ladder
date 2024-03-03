package domain;

import java.util.Map;
import java.util.stream.Collectors;
import strategy.ConnectStrategy;

public class Game {

    private final Members members;
    private final Lines lines;
    private final Rewards rewards;

    private Game(Members members, Lines lines, Rewards rewards) {
        validate(members, rewards);
        this.members = members;
        this.lines = lines;
        this.rewards = rewards;
    }

    private void validate(Members members, Rewards rewards) {
        if (members.getCount() != rewards.getCount()) {
            throw new IllegalArgumentException("플레이어 수와 상품 수가 일치하지 않습니다.");
        }
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
            .collect(Collectors.toMap(memberName -> memberName, this::findRewardName));
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
