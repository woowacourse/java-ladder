package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 높이")
public class LadderHeightTest {
    @DisplayName("개수를 가진 객체를 생성한다.")
    @Test
    void createTest() {
        // given
        int expected = 1;

        // when
        LadderHeight ladderHeight = new LadderHeight(1);

        // then
        assertThat(ladderHeight)
                .extracting("value")
                .isEqualTo(expected);
    }

    @DisplayName("1 미만이라면 예외를 발생시킨다.")
    @Test
    void minHeightExceptionTest() {
        assertThatThrownBy(() -> new LadderHeight(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1 이상의 정수이어야 합니다.");
    }
}
