package domain;

import java.util.List;

interface LineGenerator {
    List<Bridge> generateLine(Width width);
}
