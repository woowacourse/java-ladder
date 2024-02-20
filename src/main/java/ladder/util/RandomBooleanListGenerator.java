package ladder.util;

import java.util.ArrayList;
import java.util.List;

public class RandomBooleanListGenerator implements BooleanListGenerator {

    @Override
    public List<Boolean> generate(int size) {
        ArrayList<Boolean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(false);
        }
        return list;
    }
}
