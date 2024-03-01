package ladder.domain.ladder.linegenerator;

import java.util.List;
import ladder.domain.ladder.Stick;

public interface StickListGenerator {
    List<Stick> generate(int countOfPlayers);
}
