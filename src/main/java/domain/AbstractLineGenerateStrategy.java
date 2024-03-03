package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract non-sealed class AbstractLineGenerateStrategy implements LineGenerateStrategy {
    @Override
    public final List<Boolean> generate(int lineSize) {
        List<Boolean> generate = new ArrayList<>(generateStrategy(lineSize));
        fixInvalidBridges(generate);
        return Collections.unmodifiableList(generate);
    }

    public abstract List<Boolean> generateStrategy(int lineSize);

    private void fixInvalidBridges(List<Boolean> rawBridges) {
        rawBridges.set(rawBridges.size() - 1, false);
        for (int index = 1; index < rawBridges.size() - 1; index++) {
            fixIfNeed(rawBridges, index);
        }
    }

    private void fixIfNeed(List<Boolean> rawBridges, int index) {
        if (isBridgeInARow(rawBridges, index)) {
            rawBridges.set(index, false);
        }
    }

    private boolean isBridgeInARow(List<Boolean> rawBridges, int index) {
        return rawBridges.get(index) && rawBridges.get(index - 1);
    }
}
