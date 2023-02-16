package ladder.utils;

import java.util.*;

public class RandomLineStrategy implements LineStrategy {

    private final Random random = new Random();

    @Override
    public List<Boolean> generate(int partCount) {
        List<Boolean> line = new ArrayList<>();
        while (line.size() < partCount) {
            boolean current = random.nextBoolean();
            line.add(current);
            if (current && (line.size() == partCount - 1)) {
                line.add(false);
            }
        }
        return Collections.unmodifiableList(line);
    }
}
