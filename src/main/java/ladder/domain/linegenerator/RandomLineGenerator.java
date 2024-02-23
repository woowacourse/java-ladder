package ladder.domain.linegenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {
    //TODO 로직 가독성 생각해보기
    //TODO Stream.iterate 생각해보기
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
