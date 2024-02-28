package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @DisplayName("사다리는 (입력된 사용자의 수) * (입력된 높이) 사이즈의 사다리를 생성한다.")
    @Test
    void ladderSizeTest() {
        //given
        Ladder ladder = new Ladder(new Width(4), new Height(5), () -> RIGHT);

        //when
        LadderLevel anyLadderLevel = ladder.stream().findAny().get();

        int actualHeight = (int) ladder.stream().count();
        int actualPlayersCount = anyLadderLevel.getSortedDirections().size();

        // then
        assertAll(
                () -> assertThat(actualHeight).isEqualTo(5),
                () -> assertThat(actualPlayersCount).isEqualTo(4)
        );
    }

    @DisplayName("입력된 위치의 결과 위치를 반환한다")
    @Test
    void getAllResultLocationTest() {
        Ladder ladder = new Ladder(new Width(2), new Height(3), () -> RIGHT);

        assertThat(ladder.findResultLocation(new Location(0))).isEqualTo(new Location(1));
        assertThat(ladder.findResultLocation(new Location(1))).isEqualTo(new Location(0));
    }
}
