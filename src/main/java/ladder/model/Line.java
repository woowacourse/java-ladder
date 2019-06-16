package ladder.model;

import java.util.List;

public interface Line {
    int move(int position);

    List<Boolean> getHorizontalPattern();
}
