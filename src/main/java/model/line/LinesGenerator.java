package model.line;

import java.util.List;
import model.Height;

public interface LinesGenerator {
    List<Line> generate(final int height, final int pathCount);
    List<Line> generate(final Height height, final int pathCount);
}
