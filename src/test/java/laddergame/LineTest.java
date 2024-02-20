package laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import laddergame.exception.LadderLineOverlappedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {


    @DisplayName("사다리 라인을 생성한다.")
    @Test
    void create() {
        //given
        int personSize = 4;
        BooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();

        //when
        Line line = new Line(personSize, randomBooleanGenerator);

        //then
        assertThat(line.getSize()).isEqualTo(personSize - 1);
    }

    @DisplayName("가로 라인이 겹치면 예외를 발생시킨다.")
    @Test
    void overlapLine() {
        assertThatThrownBy(() -> new Line(4, () -> true))
                .isInstanceOf(LadderLineOverlappedException.class)
                .hasMessage("[ERROR] 가로 라인이 겹치면 안됩니다.");
    }


}
