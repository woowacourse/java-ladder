package domain;

import domain.ladder.Bridge;
import domain.ladder.BridgeGenerator;
import java.util.List;

public class PickedBridgeGenerator implements BridgeGenerator {

    private final List<Boolean> test;
    private int index = 0;

    public PickedBridgeGenerator(final List<Boolean> test) {
        this.test = test;
    }

    @Override
    public Bridge generate() {
        final Boolean exist = test.get(index);
        index++;
        return Bridge.getBy(exist);
    }
}
