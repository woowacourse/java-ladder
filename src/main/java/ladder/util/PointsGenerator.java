package ladder.util;

import java.util.List;
import ladder.domain.Point;

public interface PointsGenerator {

    List<Point> generate(int size);
}
