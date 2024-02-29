package model.line;

import java.util.List;
import model.bridge.Bridge;

public record LineState(List<Bridge> bridges) {
    public static LineState create(Line line) {
        return new LineState(line.getBridges());
    }
}
