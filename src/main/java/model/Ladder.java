package model;

import java.util.ArrayList;
import java.util.List;
import model.strategy.BuildStrategy;
import model.strategy.RandomBuildStrategy;

public class Ladder {
    private static final String ALL_RESULT_CMD = "all";

    private final List<Line> lines;
    private final Players players;
    private final Prizes prizes;


    protected Ladder(final List<Line> lines, final Players players, final Prizes prizes) {
        this.lines = lines;
        this.players = players;
        this.prizes = prizes;
    }

    public static Ladder of(final Height height, final Players players, final Prizes prizes) {
        List<Line> lines = new ArrayList<>();
        final int width = players.size() - 1;
        final BuildStrategy<LadderStatus> buildStrategy = new RandomBuildStrategy();
        for (int i = 0; i < height.value(); i++) {
            lines.add(new Line(width, buildStrategy));
        }
        return new Ladder(lines, players, prizes);
    }

    public LadderResult findResult() {
        final int ladderSize = players.size() - 1;
        List<String> prizeResult = new ArrayList<>();
        List<Prize> result = prizes.getPrizeValues();

        for (int index = 0; index < players.size(); index++) {
            prizeResult.add(result.get(findLadderBottomIndex(index, ladderSize)).value());
        }
        return LadderResult.of(players.getNames(), prizeResult);
    }

    private int findLadderBottomIndex(int index, final int ladderWidthSize) {
        for (Line line : lines) {
            index = move(index, ladderWidthSize, line);
        }
        return index;
    }

    private int move(final int index, final int ladderWidthSize, final Line line) {
        if (canMoveLeft(index, line)) {
            return index - 1;
        } else if (canMoveRight(index, ladderWidthSize, line)) {
            return index + 1;
        }
        return index;
    }

    private boolean canMoveRight(final int index, final int ladderWidthSize, final Line line) {
        return index < ladderWidthSize && line.isConnected(index);
    }

    private boolean canMoveLeft(final int index, final Line line) {
        return 0 < index && line.isConnected(index - 1);
    }

    public boolean isAllResultRequest(final String resultRequestCmd) {
        return ALL_RESULT_CMD.equals(resultRequestCmd);
    }

    public List<Line> getLines() {
        return lines;
    }
}
