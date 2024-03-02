package model.ladder;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import model.gameresult.GameResult;
import model.line.Line;
import model.line.LineGenerator;
import model.player.Players;
import model.prize.Prizes;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder of(LadderHeight height, LadderWidth ladderWidth,
        LineGenerator lineGenerator) {
        return IntStream.range(0, height.getValue())
            .mapToObj(i -> lineGenerator.generateLine(ladderWidth.getValue()))
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
        return lines;
    }
}
