package domain;

import java.util.List;

public interface LineGenerator {
    List<Bridge> generateLine(Width width);
}
