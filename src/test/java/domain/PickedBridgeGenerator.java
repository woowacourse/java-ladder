package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PickedBridgeGenerator implements BridgeGenerator {

    private final List<List<Boolean>> test;
    private int index = 0;

    public PickedBridgeGenerator(final List<Boolean>... test) {
        this.test = Stream.of(test)
                .map(ArrayList::new)
                .collect(Collectors.toList());
    }

    @Override
    public Bridge generate() {
        int lineSize = test.get(0).size();
        final Boolean exist = test.get(index / lineSize).get(index % lineSize);
        index++;
        return Bridge.from(exist);
    }
}
