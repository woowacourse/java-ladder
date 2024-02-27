package model.path;

import java.util.List;
import model.Line;

public interface PathGenerator {
    List<Line> generate(final int height, final int pathCount);
}
