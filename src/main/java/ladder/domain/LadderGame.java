package ladder.domain;

import java.util.List;

public class LadderGame {
    private static final String NEXT_LINE = "\n";
    private static final String INVALID_LENGTH_REWARDS_EXCEPTION_MASSAGE = "플레이어수와 리워드의 수가 다릅니다.";

    private LadderGamePlayers players;
    private LadderGameRewards rewards;
    private Ladder ladder;

    public LadderGame(List<String> names, List<String> rewards, Ladder ladder) {
        checkCount(names.size(), rewards.size());

        this.players = new LadderGamePlayers(names);
        this.rewards = new LadderGameRewards(rewards);
        this.ladder = ladder;
    }

    private void checkCount(int countOfPlayers, int countOfResults) {
        if (countOfPlayers != countOfResults) {
            throw new IllegalArgumentException(INVALID_LENGTH_REWARDS_EXCEPTION_MASSAGE);
        }
    }

    public GameResult play() {
        ladder.drawLadder();
        return ladder.getResult(players, rewards);
    }

    @Override
    public String toString() {
        return players.toString() + NEXT_LINE
                + ladder.toString() + NEXT_LINE
                + rewards.toString();
    }
}
