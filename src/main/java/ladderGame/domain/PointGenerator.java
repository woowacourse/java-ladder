package ladderGame.domain;

import java.util.List;

public interface PointGenerator {
    List<Point> makePointList(int width);
}
