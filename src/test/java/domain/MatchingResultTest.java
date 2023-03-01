package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MatchingResultTest {

    @Test
    @DisplayName("players와 results의 매칭 결과를 담은 Map을 입력하면 MatchingResult 객체가 생성된다 ")
    void makeMatchingResult() {
        Map<Player, Result> finalResult = Map.of(new Player("로이", 0), new Result("당첨"));

        Assertions.assertDoesNotThrow(() -> new MatchingResult(finalResult));
    }
}
