package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import dto.ResultRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultRequestTest {

    @DisplayName("isAll은 내부의 message가 all이면 true를 반환한다.")
    @Test
    void is_all_true() {
        // given
        ResultRequestDto request = new ResultRequestDto("all");
        // when
        boolean result = request.isAll();
        // then
        assertThat(result).isTrue();
    }

    @DisplayName("isAll은 내부의 message가 all이 아니면 false를 반환한다.")
    @Test
    void is_all_false() {
        // given
        ResultRequestDto request = new ResultRequestDto("notAll");
        // when
        boolean result = request.isAll();
        // then
        assertThat(result).isFalse();
    }
}
