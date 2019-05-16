package ladder.domain;

import java.util.List;

@FunctionalInterface
public interface SubLineGenerator {
    List<Boolean> generate();
}
