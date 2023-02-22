package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultRequestTest {

    @DisplayName("내부의 message가 all이면 true를 반환한다.")
    @Test
    void is_all_true() {
        // given
        LadderResultRequest request = new LadderResultRequest("all");

        // then
        assertThat(request.isAll()).isTrue();
    }

    @DisplayName("내부의 message가 all이 아니면 false를 반환한다.")
    @Test
    void is_all_false() {
        // given
        LadderResultRequest request = new LadderResultRequest("notAll");

        // then
        assertThat(request.isAll()).isFalse();
    }
}
