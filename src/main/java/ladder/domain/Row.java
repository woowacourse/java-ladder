package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Row {

    private static final int BUFFER_COUNT = 1;

    private final List<Leg> connected;

    Row(int width) {
        connected = new ArrayList<>(Collections.nCopies(width + BUFFER_COUNT, Leg.EMPTY));
    }

    void generateLeg(Generator generator) {
        for (int i = BUFFER_COUNT; i < connected.size(); i++) {
            connect(generator, i);
        }
    }

    private void connect(Generator generator, int index) {
        if (shouldConnect(generator, index)) {
            connected.set(index, Leg.CONNECT);
        }
    }

    private boolean shouldConnect(Generator generator, int index) {
        var adjacentIndex = index - 1;
        return generator.generate() && connected.get(adjacentIndex) == Leg.EMPTY;
    }

    List<Boolean> toDto() {
        return connected.subList(BUFFER_COUNT, connected.size())
                .stream()
                .map(Leg::getIsConnected)
                .collect(Collectors.toList());
    }
}
