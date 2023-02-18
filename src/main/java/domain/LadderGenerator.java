package domain;

import java.util.List;

@FunctionalInterface
public interface LadderGenerator {

    List<Boolean> generate(int count);
}
