package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class LadderGameTest {

    @Test
    @DisplayName("주어진 플레이어 이름들과 실행 결과, 최대 사다리 높이대로 참여자와 사다리를 생성하여 필드로 가지는 LadderGame이 생성된다.")
    void generateTest() {
        List<String> names = List.of("pobi", "crong", "seong", "haddy");
        List<String> results = List.of("꽝", "5000", "꽝", "3000");
        int height = 5;

        Assertions.assertDoesNotThrow(() -> new LadderGame(names, results, height));
    }

    @Test
    @DisplayName("각 참여자별 결과를 저장 후 반환한다.")
    void generateGameResultByPlayerTest() {
        List<String> names = List.of("pobi", "crong", "seong", "haddy");
        List<String> results = List.of("꽝", "5000", "꽝", "3000");
        int height = 5;

        LadderGame ladderGame = new LadderGame(names, results, height);
        Map<Player, Result> resultByPlayer = ladderGame.generateGameResultByPlayer();

        assertThat(resultByPlayer).isNotEmpty();
    }
}
