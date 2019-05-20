package ladder.domain.generator;

import ladder.domain.Line;

import java.util.List;

@FunctionalInterface
public interface LineGenerator {
    List<Line> generate();
}
