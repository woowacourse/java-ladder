package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderGameTest {

    @Test
    @DisplayName("주어진 플레이어 네임과 최대 사다리 높이대로 LadderGame이 생성된다.")
    void ladderGameTest() {
        List<String> names = List.of("pobi", "crong", "seong", "haddy");
        int height = 5;

        LadderGame ladderGame = new LadderGame(names, height);
        List<String> playerNames = ladderGame.getNames();
        List<Line> lines = ladderGame.getLines();

        Assertions.assertThat(playerNames).containsAll(names);
        Assertions.assertThat(lines.size()).isEqualTo(height);
    }
}
