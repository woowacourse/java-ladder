package ladder.generator;

import ladder.domain.Line;

public interface LineGenerator {
    Line makeLine(int countOfPlayers);
}
