package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderGameTest {

    @Test
    @DisplayName("주어진 플레이어 이름들과 최대 사다리 높이대로 참여자와 사다리를 생성하여 필드로 가지는 LadderGame이 생성된다.")
    void ladderGameTest() {
        List<String> names = List.of("pobi", "crong", "seong", "haddy");
        int height = 5;

        Assertions.assertDoesNotThrow(() -> new LadderGame(names, height));
    }
}
