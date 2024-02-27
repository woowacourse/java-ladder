package model.line;

import java.util.List;

public interface LinesGenerator {
    List<Line> generate(final int height, final int pathCount);
}
