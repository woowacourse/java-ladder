package domain;

public class Game {

    private final Members members;
    private final Lines lines;
    private final Rewards rewards;

    private Game(Members members, Lines lines, Rewards rewards) {
        this.members = members;
        this.lines = lines;
        this.rewards = rewards;
    }

    public static Game of(Members members, Lines lines, Rewards rewards) {
        return new Game(members, lines, rewards);
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
