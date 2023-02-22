package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String INVALID_BRIDGE_MESSAGE = "다리는 연속으로 생성되면 안됩니다.";
    private final List<Bridge> line;

    public Line(List<Bridge> line) {
        for (int index = 1; index < line.size(); index++) {
            validateLine(line, index);
        }
        this.line = line;
    }

    private void validateLine(List<Bridge> line, int index) {
        Bridge currentBridge = line.get(index);
        Bridge previousBridge = line.get(index - 1);
        if (currentBridge.isExist() && previousBridge.isExist()) {
            throw new IllegalArgumentException(INVALID_BRIDGE_MESSAGE);
        }
    }

    public List<Bridge> getLine() {
        return new ArrayList<>(line);
    }
}
