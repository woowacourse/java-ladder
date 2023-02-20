package domain;

import java.util.List;

@FunctionalInterface
public interface LadderGenerator {

    List<Line> generate(int width, int height);
}
