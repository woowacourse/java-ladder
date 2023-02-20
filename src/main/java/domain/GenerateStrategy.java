package domain;

import java.util.List;

public interface GenerateStrategy {

    List<Line> generate(int width, int height);
}
