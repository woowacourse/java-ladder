package support;

import generator.BooleanGenerator;
import java.util.List;

public class FixedBooleanGenerator implements BooleanGenerator {
    private final List<Boolean> connections;
    private int index;

    public FixedBooleanGenerator(List<Boolean> connections) {
        this.connections = connections;
    }

    @Override
    public boolean generate() {
        return connections.get(index++);
    }
}
