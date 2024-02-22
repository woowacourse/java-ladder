package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import laddergame.domain.LineSize;
import laddergame.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineSizeTest {


    @DisplayName("Names로 라인 사이즈를 결정한다.")
    @Test
    void from() {
        // given
        Names names = new Names(List.of("pobi", "zeze"));

        // when
        LineSize lineSize = new LineSize(names);

        // then
        assertThat(lineSize).extracting("lineSize").isEqualTo(1);
    }

    @DisplayName("라인 사이즈가 현재 사이즈보다 작은지 판단한다.")
    @Test
    void isBiggerThan() {
        // given
        LineSize lineSize = new LineSize(new Names(List.of("pobi", "zeze", "jk")));
        int size = 1;

        // when & then
        assertThat(lineSize.isBiggerThan(size)).isTrue();
    }
}
