package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.util.ExceptionMessageFormatter;

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
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("참여자가 " + Players.MIN_PLAYER_COUNT + "명 이상이어야 사다리를 만들 수 있습니다.",
                            playerCount));
        }
    }

    public List<Line> toUnModifiableLines() {
        return List.copyOf(lines);
    }
}
