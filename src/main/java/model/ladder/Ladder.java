package model.ladder;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.IntStream;
import model.bridge.Bridge;
import model.bridge.BridgesGenerator;
import model.line.Line;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;

public class Ladder {
    private static final int CONNECTION_OFFSET = 1;

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(LadderHeight height, Players players, BridgesGenerator bridgesGenerator) {
        int bridgeCount = players.getSize() - CONNECTION_OFFSET;
        return IntStream.range(0, height.getValue())
                .mapToObj(i -> new Line(bridgesGenerator.build(bridgeCount)))
                .collect(collectingAndThen(toList(), Ladder::new));
    }

    public LadderPlayOutcome play(Players players, Prizes prizes) {
        LinkedHashMap<Player, Prize> outcome = new LinkedHashMap<>();
        for (int index = 0; index < players.getSize(); index++) {
            Player player = players.get(index);
            int resultIndex = playLadder(index);
            Prize prize = prizes.get(resultIndex);
            outcome.put(player, prize);
        }
        return new LadderPlayOutcome(outcome);
    }

    private int playLadder(int currentIndex) {
        for (Line line : lines) {
            currentIndex = playLine(currentIndex, line);
        }
        return currentIndex;
    }

    private int playLine(int currentIndex, Line line) {
        List<Bridge> bridges = line.getBridges();
        if (currentIndex > 0 && bridges.get(currentIndex - 1).isConnected()) {
            return currentIndex - 1;
        }
        if (currentIndex < bridges.size() && bridges.get(currentIndex).isConnected()) {
            return currentIndex + 1;
        }
        return currentIndex;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
