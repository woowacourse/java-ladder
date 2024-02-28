package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SimpleStickGenerator implements StickGenerator {

    private final Queue<Stick> sticks;

    public SimpleStickGenerator(List<Stick> sticks) {
        this.sticks = new LinkedList<>(sticks);
    }

    @Override
    public Stick generateOne() {
        return sticks.poll();
    }
}
