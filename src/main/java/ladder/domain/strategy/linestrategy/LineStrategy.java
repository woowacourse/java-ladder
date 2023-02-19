package ladder.domain.strategy.linestrategy;

import ladder.domain.Line;

public interface LineStrategy {
    Line generate(int width);
}
