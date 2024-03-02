package model.line;

import java.util.List;
import model.bridge.Bridge;

public record LineState(List<Bridge> bridges) {
    public static LineState from(Line line) {
        return new LineState(line.getBridges());
    }
}
