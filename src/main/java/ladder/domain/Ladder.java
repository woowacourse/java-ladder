package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private static final int LEFT = -1;
    private static final int STAY = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 1;

    private final List<Line> lines;
    private final LadderSize ladderSize;

    public Ladder(final LadderSize ladderSize, BooleanGenerator booleanGenerator) {
        this.lines = new ArrayList<>();
        this.ladderSize = ladderSize;

        for (int height = 0; height < ladderSize.getHeight(); height++) {
            lines.add(new Line(ladderSize.getWidth(), booleanGenerator));
        }
    }

    public int getEachPlayerPrize(final int height, final int playerColumnLocation) {
        if (height >= ladderSize.getHeight()) {
            return playerColumnLocation;
        }
        int updatedPlayerColumnLocation = playerColumnLocation + decideRow(height, playerColumnLocation);

        if (playerColumnLocation == updatedPlayerColumnLocation) {
            return getEachPlayerPrize(height + DOWN, playerColumnLocation);
        }

        return getEachPlayerPrize(height + DOWN, updatedPlayerColumnLocation);
    }

    private int decideRow(final int height, final int playerColumnLocation) {
        if (playerColumnLocation == 0 || playerColumnLocation == ladderSize.getWidth()) {
            return decideRowAtEndPoint(height, playerColumnLocation);
        }
        return decideRowAtNormal(height, playerColumnLocation);
    }

    private int decideRowAtEndPoint(final int height, final int playerColumnLocation) {
        if (playerColumnLocation == 0 && lines.get(height).isConnectedAt(playerColumnLocation) == ConnectionStatus.CONNECTED) {
            return RIGHT;
        }

        if (playerColumnLocation == ladderSize.getWidth() && lines.get(height).isConnectedAt(playerColumnLocation - 1) == ConnectionStatus.CONNECTED) {
            return LEFT;
        }

        return STAY;
    }

    private int decideRowAtNormal(final int height, final int playerColumnLocation) {
        if (lines.get(height).isConnectedAt(playerColumnLocation) == ConnectionStatus.CONNECTED) {
            return RIGHT;
        }

        if (lines.get(height).isConnectedAt(playerColumnLocation - 1) == ConnectionStatus.CONNECTED) {
            return LEFT;
        }

        return STAY;
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(Line::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
