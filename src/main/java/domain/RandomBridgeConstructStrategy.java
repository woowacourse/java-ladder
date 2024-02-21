package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBridgeConstructStrategy implements BridgeConstructStrategy {

    private static final List<Boolean> BOOLEANS = List.of(true, false);

    @Override
    public Bridges generate(int count) {
        List<Boolean> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            addToBridge(result, random, i);
        }
        return new Bridges(result);
    }

    private void addToBridge(List<Boolean> result, Random random, int i) {
        if (hasPreviousBridge(result, i)) {
            result.add(false);
            return;
        }
        int nextInt = random.nextInt(2);
        Boolean randomBoolean = BOOLEANS.get(nextInt);
        result.add(randomBoolean);
    }

    private boolean hasPreviousBridge(List<Boolean> result, int i) {
        return i != 0 && result.get(i - 1);
    }
}
