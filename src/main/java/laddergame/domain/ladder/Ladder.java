package laddergame.domain.ladder;

import laddergame.domain.connectiongenerator.ConnectionGenerator;
import laddergame.domain.connectiongenerator.RandomConnectionGenerator;
import laddergame.domain.gameelements.Players;

import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final List<RowLine> rowLines;
    private final Height height;

    public Ladder(int height, int peopleNumber) {
        this(height, peopleNumber, new RandomConnectionGenerator());
    }

    public Ladder(int height, int peopleNumber, ConnectionGenerator connectionGenerator) {
        this.height = new Height(height);
        this.rowLines = Stream.generate(() -> new RowLine(peopleNumber, connectionGenerator))
                .limit(this.height.getHeight())
                .toList();
    }

    public void getResult(Players players) {

        for (RowLine rowLine : rowLines) {
            rowLine.move(players);
        }

//        return players;
    }

    public List<RowLine> getRowLines() {
        return rowLines;
    }
}
