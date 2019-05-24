package ladder.domain;

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
