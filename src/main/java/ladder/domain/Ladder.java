package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.util.ExceptionMessageFormatter;

public class Ladder {

    private final List<Line> lines;
    private final Destination destination;

    private Ladder(List<Line> lines, Destination destination) {
        this.lines = lines;
        this.destination = destination;
    }

    public static Ladder of(int playerCount, LadderHeight height, Destination destination) {
        validatePlayerCount(playerCount);
        validateDestination(playerCount, destination);
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height.get(); i++) {
            lines.add(Line.of(new RandomStepPointGenerator(), new LineWidth(playerCount)));
        }
        return new Ladder(lines, destination);
    }

    private static void validatePlayerCount(int playerCount) {
        if (playerCount < Players.MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("참여자가 " + Players.MIN_PLAYER_COUNT + "명 이상이어야 사다리를 만들 수 있습니다.",
                            playerCount));
        }
    }

    private static void validateDestination(int playerCount, Destination destination) {
        if (destination.size() != playerCount) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("종착지의 개수는 참여자 수인 " + playerCount + "명과 일치해야 합니다.",
                            destination.size())
            );
        }
    }

    public List<Line> toUnModifiableLines() {
        return List.copyOf(lines);
    }
}
