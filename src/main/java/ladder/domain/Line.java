package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Line {

    private final List<Boolean> connected;

    Line(Height height) {
        connected = new ArrayList<>(Collections.nCopies(height.getHeight(), false));
    }

    void connectHeight(int height) {
        connected.set(height, true);
    }

    boolean isConnected(int height) {
        return connected.get(height);
    }

    List<Boolean> toDto() {
        return connected;
    }
}
