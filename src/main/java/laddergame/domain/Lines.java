package laddergame.domain;

import java.util.List;
import java.util.stream.IntStream;
import laddergame.domain.strategy.BuildStrategy;

public class Lines {
    private final List<Line> lines;

    public static Lines from(Height height, Players players, final BuildStrategy buildStrategy) {
        return new Lines(IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Line(players.getPlayersSize(), buildStrategy))
                .toList());
    }

    private Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public Direction getDirection(final int nowHeight, final int position) {
        return this.lines.get(nowHeight).getDirection(position);
    }

    public int getSize() {
        return this.lines.size();
    }

    public Line getLine(final int lineIndex) {
        return this.lines.get(lineIndex);
    }
}
