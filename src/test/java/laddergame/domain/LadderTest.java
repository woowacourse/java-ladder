package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.LineSize;
import laddergame.domain.player.Players;
import laddergame.domain.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @DisplayName("사다리높이만큼 라인을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void create(int value) {
        // given
        final LadderHeight height = new LadderHeight(value);
        final LineSize lineSize = new LineSize(new Players(List.of("pobi", "zeze", "crong", "jk")));

        // when
        Ladder ladder = Ladder.create(lineSize, height, () -> Point.EXIST);

        // then
        assertThat(ladder.getLines()).hasSize(value);
    }
}
