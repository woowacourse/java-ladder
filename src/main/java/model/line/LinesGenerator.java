package model.line;

import java.util.List;
import model.ladder.Height;

public interface LinesGenerator {
    List<Line> generate(final Height height, final int pathCount);
}
