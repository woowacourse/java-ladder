package ladder.domain;

import static java.util.stream.Collectors.toList;

import ladder.domain.strategy.linestrategy.LineStrategy;
import java.util.List;
import java.util.stream.IntStream;

public class LadderFactory {
    private static final int MAX_HEIGHT_RATIO = 2;

    private final Height height;
    private final Players players;
    private final LineStrategy lineStrategy;

    public LadderFactory(Height height, Players players, LineStrategy lineStrategy) {
        validatePlayersCount(height.getHeight(), players.getPlayersCount());
        this.height = height;
        this.players = players;
        this.lineStrategy = lineStrategy;
    }

    private void validatePlayersCount(int height, int playersCount) {
        if (isProperRange(height, playersCount)) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
        }
    }

    private boolean isProperRange(int height, int playersCount) {
        return playersCount * MAX_HEIGHT_RATIO < height || height < playersCount;
    }

    public Ladder makeLadder() {
        int width = players.getPlayersCount();

        List<Line> lines = IntStream.range(0, height.getHeight())
                .mapToObj(x -> lineStrategy.generate(width))
                .collect(toList());
        return new Ladder(lines);
    }
}
