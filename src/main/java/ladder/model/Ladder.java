package ladder.model;

import java.util.List;

public interface Ladder {
    LadderResult play();

    List<Line> getLines();
}
