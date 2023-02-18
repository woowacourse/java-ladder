package ladder.domain.generator;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Players;

public class LadderGenerator {

    public Ladder generate(final LineGenerator lineGenerator, final Players players, final Height height) {
        final List<Line> lines = new ArrayList<>();
        final int numberOfPlayers = players.size();
        int count = height.getValue();

        while (count-- > 0) {
            lines.add(lineGenerator.generate(new RandomDirectionGenerator(), numberOfPlayers));
        }
        return new Ladder(lines);
    }
}
