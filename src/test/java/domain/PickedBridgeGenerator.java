package domain;

import java.util.List;

class PickedBridgeGenerator implements BridgeGenerator {

    private List<Boolean> test;
    private int index = 0;

    public PickedBridgeGenerator(final List<Boolean> test) {
        this.test = test;
    }

    @Override
    public Bridge generate() {
        final Boolean exist = test.get(index % test.size());
        index++;
        return Bridge.getBy(exist);
    }
}
