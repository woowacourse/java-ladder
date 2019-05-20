package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private static final String NEXT_LINE = "\n";


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
            throw new IllegalArgumentException("플레이어수와 리워드의 수가 다릅니다.");
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
