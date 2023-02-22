package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @Test
    @DisplayName("실행 결과들을 생성한다.")
    void generateTest() {
        Result result1 = new Result(new Reward("꽝"));
        Result result2 = new Result(new Reward("5000"));

        Assertions.assertDoesNotThrow(() -> new Results(List.of(result1, result2)));
    }
}
