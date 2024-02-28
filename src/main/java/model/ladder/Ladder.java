package model.ladder;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import model.gameResult.GameResult;
import model.line.Line;
import model.line.LineGenerator;
import model.player.Players;
import model.prize.Prizes;

public class Ladder {
    private static final int LINE_WIDTH_OFFSET = 1;

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(LadderHeight height, Players players, LineGenerator LineGenerator) {
        int lineWidth = players.getSize() - LINE_WIDTH_OFFSET;
        return IntStream.range(0, height.value())
                .mapToObj(i -> LineGenerator.generateLine(lineWidth))
                .collect(collectingAndThen(toList(), Ladder::new));
    }

    public GameResult simulate(Players players, Prizes prizes) {
        List<Integer> positions = IntStream.range(0, players.getSize())
                .boxed()
                .collect(toList());
        lines.forEach(line -> positions.replaceAll(line::cross));
        return GameResult.of(Collections.unmodifiableList(positions), players, prizes);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
