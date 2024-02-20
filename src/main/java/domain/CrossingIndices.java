package domain;

import java.util.ArrayList;
import java.util.List;

public class CrossingIndices {

    private final List<Integer> indices = new ArrayList<>();

    public void add(int value) {
        if (indices.isEmpty() || isLastElementNotSameAs(value)) {
            indices.add(value);
        }
    }

    public void clear() {
        indices.clear();
    }

    public List<Integer> getCopyOfIndices() {
        return List.copyOf(indices);
    }

    private boolean isLastElementNotSameAs(int value) {
        return indices.get(indices.size() - 1) != value - 1;
    }
}
