package laddergame.util;

import laddergame.domain.Line;

import java.util.List;

public interface LinesGenerator {
    List<Line> generate(int width);
}
