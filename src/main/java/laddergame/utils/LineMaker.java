package laddergame.utils;

import laddergame.domain.PointImpl;
import java.util.List;

public interface LineMaker {

    List<PointImpl> generateLine(int userCount);

}
