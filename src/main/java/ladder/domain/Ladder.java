package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int playerCount, LadderHeight height) {
        validatePlayerCount(playerCount);
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height.get(); i++) {
            lines.add(Line.of(new RandomStepPointGenerator(), new LineWidth(playerCount - 1)));
        }
        return new Ladder(lines);
    }

    private static void validatePlayerCount(int playerCount) {
        if (playerCount < Players.MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참여자가 2명 이상이어야 사다리를 만들 수 있습니다.");
        }
    }

    public List<Line> toUnModifiableLines() {
        return List.copyOf(lines);
    }
}
