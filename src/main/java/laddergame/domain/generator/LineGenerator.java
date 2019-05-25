package laddergame.domain.generator;

import laddergame.domain.Line;

public interface LineGenerator {
    boolean FIRST_VALUE_OF_LINE = false;

    Line makeLine(int width);
}
