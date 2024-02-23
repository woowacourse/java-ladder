package laddergame.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.LadderHeight;
import laddergame.domain.Names;
import laddergame.domain.Point;
import laddergame.dto.GameResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {


    @DisplayName("사다리 게임이 초기화 된다.")
    @Test
    void create() {
        // given
        final List<String> input = List.of("pobi", "honux", "crong", "jk");

        final Names names = new Names(input);
        final LadderHeight height = new LadderHeight(5);

        final LadderGame ladderGame = new LadderGame(() -> Point.EXIST);

        // when
        final GameResultDto result = ladderGame.createLadder(names, height);

        // then
        assertThat(result.names()).isEqualTo(input);
        assertThat(result.ladder()).hasSize(5)
                .isEqualTo(createLadder(List.of(true, false, true), 5));
    }

    private List<List<Boolean>> createLadder(final List<Boolean> line, final int size) {
        List<List<Boolean>> ladder = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ladder.add(line);
        }
        return ladder;
    }
}
