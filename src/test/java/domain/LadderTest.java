package domain;

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
        assertThatCode(() -> Ladder.of(maxHeight, personCount, () -> true)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리를 생성한다")
    void generate() {
        //given
        int maxHeight = 4;
        int personCount = 4;
        //when
        Ladder ladder = Ladder.of(maxHeight, personCount, () -> true);
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
        assertThatThrownBy(() -> Ladder.of(maxHeight, personCount, () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리를 탄다")
    void methodName() {
        //given
        Ladder ladder = Ladder.of(3, 4, () -> true);
        /*
                사다리 모양
                |-----|     |-----|
                |-----|     |-----|
                |-----|     |-----|
         */


        //when
        //then
        Assertions.assertAll(
                () -> assertThat(ladder.climb(0)).isEqualTo(1),
                () -> assertThat(ladder.climb(1)).isZero(),
                () -> assertThat(ladder.climb(2)).isEqualTo(3),
                () -> assertThat(ladder.climb(3)).isEqualTo(2)
        );

    }
}
