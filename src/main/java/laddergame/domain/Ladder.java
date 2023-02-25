package laddergame.domain;

import java.util.List;

public interface Ladder {
    List<? extends Line> getLines();
}
