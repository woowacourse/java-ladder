package ladder.domain;

import static ladder.domain.ladder.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Stream;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderLevel;
import ladder.domain.ladder.Width;
import ladder.domain.player.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderTest {
    @DisplayName("사다리는 (입력된 사용자의 수) * (입력된 높이) 사이즈의 사다리를 생성한다.")
    @Test
    void ladderSizeTest() {
        //given
        Ladder ladder = new Ladder(new Width(4), new Height(5), () -> RIGHT);

        //when
        LadderLevel anyLadderLevel = ladder.stream().findAny().get();

        int actualHeight = (int) ladder.stream().count();
        int actualPlayersCount = anyLadderLevel.getDirections().size();

        // then
        assertAll(
                () -> assertThat(actualHeight).isEqualTo(5),
                () -> assertThat(actualPlayersCount).isEqualTo(4)
        );
    }

    private static Stream<Arguments> inputAndExpectedLocation() {
        return Stream.of(
                Arguments.of(new Location(0), new Location(1)),
                Arguments.of(new Location(1), new Location(0))
        );
    }

    @DisplayName("입력된 위치의 결과 위치를 반환한다")
    @MethodSource("inputAndExpectedLocation")
    @ParameterizedTest
    void getAllResultLocationTest(Location input, Location expected) {
        Ladder ladder = new Ladder(new Width(2), new Height(3), () -> RIGHT);

        assertThat(ladder.findResultLocation(input)).isEqualTo(expected);
    }
}
