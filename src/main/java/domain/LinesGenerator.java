package domain;

import java.util.List;

public interface LinesGenerator {

    List<Line> generate(int width, int height);
}
