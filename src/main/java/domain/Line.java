package domain;

import domain.generator.Generator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Bridge> bridges = new ArrayList<>();

    public Line(int playersCount, Generator generator) {
        generate(playersCount, generator);
    }

    private void generate(int playersCount, Generator generator) {
        for (int position = 0; position < playersCount - 1; position++) {
            makePoint(generator);
        }
    }

    private void makePoint(Generator generator) {
        if (bridges.isEmpty() || isPreviousBridgeBlank()) {
            makeBridge(generator);
            return;
        }
        addBlankBridge();
    }

    private boolean isPreviousBridgeBlank() {
        return !bridges.get(getBridgeCount() - 1).isExist();
    }

    private void addBlankBridge() {
        bridges.add(Bridge.BLANK);
    }

    private void makeBridge(Generator generator) {
        if (generator.generate()) {
            bridges.add(Bridge.EXIST);
            return;
        }
        addBlankBridge();
    }

    public int getBridgeCount() {
        return bridges.size();
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
