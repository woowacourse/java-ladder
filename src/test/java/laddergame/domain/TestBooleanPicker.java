package laddergame.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestBooleanPicker implements PickStrategy {

    private final Queue<Boolean> booleans;

    public TestBooleanPicker(final List<Boolean> testBooleans) {
        this.booleans = new LinkedList<>(testBooleans);
    }

    @Override
    public boolean pick() {
        return booleans.remove();
    }
}
