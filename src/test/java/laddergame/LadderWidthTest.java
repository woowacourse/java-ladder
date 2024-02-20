package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import laddergame.domain.LadderWidth;
import laddergame.domain.Names;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderWidthTest {
    @DisplayName("참가자이름의 길이로 사다리 폭을 계산한다.")
    @Test
    void create() {
        // given
        Names names = new Names(List.of("pobi","crong","jk"));

        // when
        LadderWidth ladderWidth = LadderWidth.from(names);

        // then
        Assertions.assertThat(ladderWidth.getWidth()).isEqualTo(5);
    }

    @DisplayName("마지막 참여자의 이름길이가 최대값일때 사디리 폭의 길이는 (최대값+1)이다.")
    @Test
    void lastNameMax() {
        // given
        Names names = new Names(List.of("pobi", "honux", "jk", "crong"));

        // when
        final LadderWidth width = LadderWidth.from(names);

        // then
        assertThat(width.getWidth()).isEqualTo(6);
    }

}
