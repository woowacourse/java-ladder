package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class LadderGenerateStrategy implements Function<Integer, List<Boolean>> {

    @Override
    public List<Boolean> apply(Integer count) {
        List<Boolean> row = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            row.add(new Random().nextBoolean());
        }
        return row;
    }

}
