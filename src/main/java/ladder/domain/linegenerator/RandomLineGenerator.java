package ladder.domain.linegenerator;

import ladder.domain.linegenerator.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {
    @Override
    public List<Boolean> getLine(int peopleNumber) {

        List<Boolean> line = new ArrayList<>();
        boolean before = false;
        for (int i = 0; i < peopleNumber - 1; i++) {
            addBoolean(before, line);
            before = line.get(i);
        }
        return line;
    }

    private void addBoolean(boolean before, List<Boolean> line) {
        if (before) {
            line.add(false);
        }
        if (!before) {
            line.add(Math.random() >= 0.5);
        }
    }
}
