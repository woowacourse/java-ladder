package ladder.domain.connectiongenerator;

import java.util.List;

public interface ConnectionGenerator {
    List<Boolean> getConnection(int peopleNumber);
}
