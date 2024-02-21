package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {


    @DisplayName("중복되지 않은 라인을 생성한다.")
    @Test
    void create() {
        // given & when
        Line line = Line.create(3, size -> new ArrayList<>(List.of(true, true, true)));

        //then
        assertThat(line).extracting("points")
                .isEqualTo(List.of(true, false, true));
    }
}
