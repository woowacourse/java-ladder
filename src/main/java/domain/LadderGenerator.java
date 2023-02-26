package domain;

import java.util.List;

public interface LadderGenerator {
    List<Line> generate(int width, Height height);
}
