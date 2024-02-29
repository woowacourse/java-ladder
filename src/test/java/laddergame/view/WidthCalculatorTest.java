package laddergame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WidthCalculatorTest {


    @DisplayName("참가자이름의 길이로 사다리 폭을 계산한다.")
    @Test
    void create() {
        // given & when
        final int size = WidthCalculator.calculateWidth(List.of("pobi", "crong", "jk"));

        // then
        assertThat(size).isEqualTo(5);
    }

    @DisplayName("마지막 참여자의 이름길이가 최대값일때 사디리 폭의 길이는 (최대값+1)이다.")
    @Test
    void lastNameMax() {
        // given & when
        final int size = WidthCalculator.calculateWidth(List.of("pobi", "crong", "jk", "crong"));

        // then
        assertThat(size).isEqualTo(6);
    }
}
