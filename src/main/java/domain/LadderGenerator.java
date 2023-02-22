package domain;

import java.util.List;

public interface LadderGenerator {
    List<Line> generate(Width width, Height height);
}
