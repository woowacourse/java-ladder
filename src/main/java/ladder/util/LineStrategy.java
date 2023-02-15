package ladder.util;

import ladder.domain.Line;

public interface LineStrategy {
    Line generate(int width);
}
