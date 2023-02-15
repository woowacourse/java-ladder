package ladder.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineStrategy implements LineStrategy {

    Random random = new Random();

    @Override
    public List<Boolean> generate(int lineLength) {
        List<Boolean> line = new ArrayList<>();
        while(line.size() < lineLength) {
            boolean current = random.nextBoolean();
            line.add(current);
            if(current && (line.size() == lineLength - 1)) {
                line.add(false);
            }
        }
        return line;
    }
}
