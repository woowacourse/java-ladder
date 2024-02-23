package domain;

import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
