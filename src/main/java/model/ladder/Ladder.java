package model.ladder;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import model.bridge.BridgesGenerator;
import model.line.Line;
import model.player.Players;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(LadderHeight height, Players players, BridgesGenerator bridgesGenerator) {
        int bridgeCount = players.getSizeOfPlayers() - 1;
        return IntStream.range(0, height.value())
                .mapToObj(i -> new Line(bridgesGenerator.pickBridges(bridgeCount)))
                .collect(collectingAndThen(toList(), Ladder::new));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
