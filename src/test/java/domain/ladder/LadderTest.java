package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("위치를 받으면 사다리를 따라 이동한 결과 위치를 반환한다.")
    @Test
    void climbLadder() {
        //given
        final Ladder ladder = new Ladder(List.of(
                new Floor(List.of(Bridge.EXIST, Bridge.NOT_EXIST, Bridge.EXIST)),
                new Floor(List.of(Bridge.NOT_EXIST, Bridge.EXIST, Bridge.NOT_EXIST)),
                new Floor(List.of(Bridge.EXIST, Bridge.NOT_EXIST, Bridge.NOT_EXIST)),
                new Floor(List.of(Bridge.NOT_EXIST, Bridge.EXIST, Bridge.NOT_EXIST)),
                new Floor(List.of(Bridge.EXIST, Bridge.NOT_EXIST, Bridge.EXIST)))
        );

        // when & then
        assertAll(
                () -> assertThat(ladder.calculateResultPosition(0)).isEqualTo(0),
                () -> assertThat(ladder.calculateResultPosition(1)).isEqualTo(3),
                () -> assertThat(ladder.calculateResultPosition(2)).isEqualTo(2),
                () -> assertThat(ladder.calculateResultPosition(3)).isEqualTo(1)
        );
    }
}
