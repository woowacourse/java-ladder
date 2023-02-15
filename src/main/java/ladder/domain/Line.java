package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Line {

    private final List<Boolean> connected;

    //todo width 고민
    Line(int width) {
        connected = new ArrayList<>(Collections.nCopies(width, false));
    }

    //todo 메서드명 변경
    void generateRandom(Generator generator) {
        for (int i = 1; i < connected.size(); i++) {
            connect(generator, i);
        }
    }

    private void connect(Generator generator, int i) {
        if (shouldConnect(generator, i)) {
            connected.set(i, true);
        }
    }

    private boolean shouldConnect(Generator generator, int index) {
        return generator.generate() && !connected.get(index - 1);
    }

    List<Boolean> toDto() {
        return connected.subList(1, connected.size());
    }
}
