package ladder.domain;

import java.util.List;

@FunctionalInterface
public interface LineGenerator {
    List<Line> generate();
}
