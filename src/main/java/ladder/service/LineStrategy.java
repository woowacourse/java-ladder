package ladder.service;

import ladder.domain.Line;

public interface LineStrategy {
    Line generate(int width);
}
