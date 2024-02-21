package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBridgeConstructStrategy implements BridgeConstructStrategy {

    @Override
    public Bridges generate(int count) {
        List<Boolean> booleans = new ArrayList<>(List.of(true, false));
        List<Boolean> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            if (i != 0 && result.get(i - 1)) {
                result.add(false);
                continue;
            }
            int nextInt = random.nextInt(2);
            Boolean randomBoolean = booleans.get(nextInt);
            result.add(randomBoolean);
        }
        return new Bridges(result);
    }
}
