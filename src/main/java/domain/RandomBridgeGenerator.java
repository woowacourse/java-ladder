package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {

    private static final Random random = new Random();

    @Override
    public List<Boolean> generate(int count) {
        List<Boolean> result = new ArrayList<>(count);
        result.add(random.nextBoolean());

        for (int i = 1; i < count; i++) {
            if (result.get(i - 1)) {
                result.add(false);
                continue;
            }
            result.add(random.nextBoolean());
        }
        return result;
    }
}
