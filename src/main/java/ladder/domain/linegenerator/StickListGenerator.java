package ladder.domain.linegenerator;

import java.util.List;
import ladder.domain.Stick;

public interface StickListGenerator {
    List<Stick> generate(int countOfPlayers);
}
