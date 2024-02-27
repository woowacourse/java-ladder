package model.path;

import java.util.List;
import model.Line;

public interface PathGenerator {
    List<Path> generate(final int count);
    List<Line> generate(final int height, final int pathCount);
}
