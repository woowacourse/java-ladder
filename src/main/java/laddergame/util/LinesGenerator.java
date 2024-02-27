package laddergame.util;

import laddergame.domain.Line;
import laddergame.domain.Lines;

import java.util.List;

public interface LinesGenerator {
    Lines generate(int width);
}
