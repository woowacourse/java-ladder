package ladder.domain.generator;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Players;

public class LadderGenerator {

    private final LineGenerator lineGenerator;

    public LadderGenerator(final LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Ladder generate(final Players players, final Height height) {
        final List<Line> lines = new ArrayList<>();
        final int numberOfPlayers = players.numberOfPlayers();
        int count = height.getValue();

        while (count-- > 0) {
            lines.add(lineGenerator.generate(numberOfPlayers));
        }
        return new Ladder(lines);
    }
}
