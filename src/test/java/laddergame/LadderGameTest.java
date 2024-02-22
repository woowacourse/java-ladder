package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import laddergame.domain.Point;
import laddergame.service.LadderGame;
import laddergame.domain.LadderHeight;
import laddergame.domain.Names;
import laddergame.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {


    @DisplayName("사다리 게임이 초기화 된다.")
    @Test
    void init() {
        // given
        final List<String> input = List.of("pobi", "honux", "crong", "jk");

        final Names names = new Names(input);
        final LadderHeight height = new LadderHeight(5);

        final LadderGame ladderGame = new LadderGame(() -> Point.EXIST);

        // when
        final Result result = ladderGame.createLadder(names, height);

        // then
        assertThat(result.names()).isEqualTo(input);
        assertThat(result.ladder()).hasSize(5)
                .isEqualTo(LadderTest.createLadder(List.of(true, false, true), 5));
    }
}
