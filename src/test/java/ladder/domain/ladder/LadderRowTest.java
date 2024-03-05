package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import static ladder.domain.ladder.direction.LadderDirection.LEFT;
import static ladder.domain.ladder.direction.LadderDirection.NONE;
import static ladder.domain.ladder.direction.LadderDirection.RIGHT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.attribute.Width;

class LadderRowTest {

    @DisplayName("가로줄이 없는 사다리 층이 생성된다.")
    @Test
    void ladderRowConstructTest() {
        LadderRow ladderRow = LadderRow.of(new Width(5), () -> NONE);

        assertAll(
                () -> assertThat(ladderRow.ladderDirectionAt(0)).isEqualTo(NONE),
                () -> assertThat(ladderRow.ladderDirectionAt(1)).isEqualTo(NONE),
                () -> assertThat(ladderRow.ladderDirectionAt(2)).isEqualTo(NONE),
                () -> assertThat(ladderRow.ladderDirectionAt(3)).isEqualTo(NONE),
                () -> assertThat(ladderRow.ladderDirectionAt(4)).isEqualTo(NONE)
        );
    }

    @DisplayName("가로줄로 가득 찬 사다리 층이 생성된다.")
    @Test
    void ladderRowIntegrityTest() {
        LadderRow ladderRow = LadderRow.of(new Width(6), () -> RIGHT);

        assertAll(
                () -> assertThat(ladderRow.ladderDirectionAt(0)).isEqualTo(RIGHT),
                () -> assertThat(ladderRow.ladderDirectionAt(1)).isEqualTo(LEFT),
                () -> assertThat(ladderRow.ladderDirectionAt(2)).isEqualTo(RIGHT),
                () -> assertThat(ladderRow.ladderDirectionAt(3)).isEqualTo(LEFT),
                () -> assertThat(ladderRow.ladderDirectionAt(4)).isEqualTo(RIGHT),
                () -> assertThat(ladderRow.ladderDirectionAt(5)).isEqualTo(LEFT)
        );
    }

    @DisplayName("생성을 위해 필요한 값이 입력되지 않으면 예외를 발생한다.")
    @Test
    void npeTest() {
        assertAll(
                () -> assertThatThrownBy(() -> LadderRow.of(null, () -> NONE))
                        .isInstanceOf(NullPointerException.class)
                        .hasMessage("사다리의 너비가 입력되지 않았습니다."),
                () -> assertThatThrownBy(
                        () -> LadderRow.of(new Width(1), null))
                        .isInstanceOf(NullPointerException.class)
                        .hasMessage("사다리 방향 선택자가 입력되지 않았습니다.")
        );
    }
}
