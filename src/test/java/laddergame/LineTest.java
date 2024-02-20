package laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import laddergame.domain.BooleanGenerator;
import laddergame.domain.Line;
import laddergame.exception.LadderLineOverlappedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {


    @DisplayName("사다리 라인을 생성한다.")
    @Test
    void create() {
        //given
        int personSize = 4;

        //when
        Line line = Line.create(personSize, new RotationBooleanGenerator());

        //then
        assertThat(line.getSize()).isEqualTo(personSize - 1);
    }

    @DisplayName("가로 라인이 겹치면 예외를 발생시킨다.")
    @Test
    void overlapLine() {
        assertThatThrownBy(() -> Line.create(4, () -> true))
                .isInstanceOf(LadderLineOverlappedException.class)
                .hasMessage("[ERROR] 가로 라인이 겹치면 안됩니다.");
    }

    private static class RotationBooleanGenerator implements BooleanGenerator {
        private static boolean value = true;

        @Override
        public Boolean generate() {
            return value = !value;
        }
    }
}
