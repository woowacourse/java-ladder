package laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import laddergame.domain.Line;
import laddergame.exception.LadderLineOverlappedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {


    @DisplayName("사다리 라인을 생성한다.")
    @Test
    void create() {
        //given
        List<Boolean> booleans = List.of(true, false, true);

        //when
        Line line = Line.create(() -> booleans);

        //then
        assertThat(line.getSize()).isEqualTo(booleans.size());
    }

    @DisplayName("가로 라인이 겹치면 예외를 발생시킨다.")
    @Test
    void overlapLine() {
        assertThatThrownBy(() -> Line.create(() -> List.of(true, true, true)))
                .isInstanceOf(LadderLineOverlappedException.class)
                .hasMessage("[ERROR] 가로 라인이 겹치면 안됩니다.");
    }
}
