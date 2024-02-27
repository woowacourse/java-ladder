package domain;

import domain.Ladder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.Bridge.*;
import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사람 수와 높이로 Ladder 생성")
    void createLadderWithPersonCountAndMaxHeight() throws Exception {
        //given
        int maxHeight = 4;
        int personCount = 4;
        //when
        //then
        assertThatCode(() -> new Ladder(maxHeight, personCount)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리를 생성한다")
    void generate() {
        //given
        int maxHeight = 4;
        int personCount = 4;
        //when
        Ladder ladder = new Ladder(maxHeight, personCount);
        //then
        assertThat(maxHeight).isEqualTo(ladder.getHeight());
    }

    @Test
    @DisplayName("사다리 최대 높이는 100이다.")
    void maxHeight() {
        //given
        int maxHeight = 101;
        int personCount = 4;
        //when
        //then
        assertThatThrownBy(() -> new Ladder(maxHeight, personCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리를 탄다")
    void methodName() {
        //given
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(BRIDGE, NON_BRIDGE, BRIDGE)),
                new Line(List.of(NON_BRIDGE, BRIDGE, NON_BRIDGE)),
                new Line(List.of(BRIDGE, NON_BRIDGE, NON_BRIDGE)),
                new Line(List.of(NON_BRIDGE, BRIDGE, NON_BRIDGE)),
                new Line(List.of(BRIDGE, NON_BRIDGE, BRIDGE)))
        );

        /*      |-----|     |-----|
                |     |-----|     |
                |-----|     |     |
                |     |-----|     |
                |-----|     |-----|
         */

        //when
        //then
        Assertions.assertAll(
                () -> assertThat(ladder.climb(0)).isZero(),
                () -> assertThat(ladder.climb(1)).isEqualTo(3),
                () -> assertThat(ladder.climb(2)).isEqualTo(2),
                () -> assertThat(ladder.climb(3)).isEqualTo(1)
        );

    }

}
