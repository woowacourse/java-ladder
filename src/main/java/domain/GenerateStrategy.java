package domain;

import java.util.List;

@FunctionalInterface
public interface GenerateStrategy {

    List<Boolean> generate(int count);
}
