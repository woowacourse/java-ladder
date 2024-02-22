package ladder.domain;

import java.util.ArrayList;
import java.util.List;
//TODO 패키지 이동(test와 구분)
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
