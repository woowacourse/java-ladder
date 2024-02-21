package ladder.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBooleanListGenerator implements BooleanListGenerator {

    @Override
    public List<Boolean> generate(int size) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            boolean value = new Random().nextBoolean();
            list.add(value);
        }
        return list;
    }
}
