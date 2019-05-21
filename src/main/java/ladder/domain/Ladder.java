package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String VIOLATE_LADDER_HEIGHT_POSITIVE = "사다리의 높이를 양수로 입력해주세요.";

    private List<Line> lines = new ArrayList<>();

    public Ladder(int playerNum, int height) {
        checkHeightIsPositive(height);

        for (int i = 0; i < height; ++i) {
            lines.add(new Line(playerNum));
        }
    }

    public static void checkHeightIsPositive(int height) {
        if (height < 0) {
            throw new NumberFormatException(VIOLATE_LADDER_HEIGHT_POSITIVE);
        }
    }

    public Player goDownLadder(Player player) {
        for (Line line : lines) {
            line.getNextPositon(player);
        }
        return player;
    }

    @Override
    public String toString() {
        List<String> ladderElements = new ArrayList<>();

        for (Line line : lines) {
            ladderElements.add(line.toString());
        }
        return String.join("\n", ladderElements);
    }
}
