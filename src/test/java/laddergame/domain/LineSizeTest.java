package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineSizeTest {


    @DisplayName("Names로 라인 사이즈를 결정한다.")
    @Test
    void create() {
        // given
        final Names names = new Names(List.of("pobi", "zeze"));

        // when
        final LineSize lineSize = new LineSize(names);

        // then
        assertThat(lineSize).extracting("lineSize").isEqualTo(1);
    }
}
