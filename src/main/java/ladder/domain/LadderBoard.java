package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderBoard {
    private static final int NAME_FORMAT_LEN = 6;
    private static final String ENTER = "\n";

    private final Ladder ladder;
    private final Players players;
    private final Rewards rewards;

    LadderBoard(Ladder ladder, Players players, Rewards rewards) {
        this.ladder = ladder;
        this.players = players;
        this.rewards = rewards;
    }

    public static LadderBoard of(Ladder ladder, Players players, Rewards rewards) {
        return new LadderBoard(ladder, players, rewards);
    }

    public GameResult play() {
        LadderMatchingIndice toIndice = ladder.match();
        List<Reward> resultRewards = new ArrayList<>();
        for (int from = 0; from < players.size(); from++) {
            int to = toIndice.to(from);
            resultRewards.add(rewards.getReward(to));
        }

        return GameResult.of(players.toList(), resultRewards);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(formatNames(players) + ENTER);
        sb.append(ladder.toString());
        sb.append(formatNames(rewards) + ENTER);

        return sb.toString();
    }

    private String formatNames(Names names) {
        StringBuilder sb = new StringBuilder();

        String format = String.format("%%%ds", NAME_FORMAT_LEN);
        for (int i = 0; i < names.size(); i++) {
            sb.append(String.format(format, names.getName(i)));
        }

        return sb.toString();
    }
}
