package ladder.domain;

import java.util.List;

//TODO 패키지 이동(LineGenerator 한 패키지로 이동)
public interface LineGenerator {
    List<Boolean> getLine(int peopleNumber);
}
