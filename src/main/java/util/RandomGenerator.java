package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator implements Generator{
    public RandomGenerator() {}

    @Override
    public List<Integer> generate(int personCount) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < personCount; ++i) {
            result.add(random.nextInt(10));
        }
        return result;
    }
}
