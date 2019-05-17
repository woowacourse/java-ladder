package ladder.domain.generator;

import java.util.List;

@FunctionalInterface
public interface SubLineGenerator {
    List<Boolean> generate();
}
