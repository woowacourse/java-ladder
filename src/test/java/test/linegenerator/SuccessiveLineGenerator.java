package test.linegenerator;

import ladder.domain.linegenerator.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class SuccessiveLineGenerator implements LineGenerator {
    @Override
    public List<Boolean> getLine(int peopleNumber) {
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < peopleNumber - 1; i++) {
            line.add(Boolean.TRUE);
        }

        return line;
    }
}
