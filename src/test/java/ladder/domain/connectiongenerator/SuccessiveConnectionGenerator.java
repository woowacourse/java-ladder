package ladder.domain.connectiongenerator;

import java.util.ArrayList;
import java.util.List;

public class SuccessiveConnectionGenerator implements ConnectionGenerator {
    @Override
    public List<Boolean> getConnection(int peopleNumber) {
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < peopleNumber - 1; i++) {
            line.add(Boolean.TRUE);
        }

        return line;
    }
}
