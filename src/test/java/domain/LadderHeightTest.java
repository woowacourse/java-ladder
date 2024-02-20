package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 높이")
public class LadderHeightTest {
    @DisplayName("개수를 가진 객체를 생성한다.")
    @Test
    void createTest() {
        // given
        String height = "1";
        int expected = 1;

        // when
        LadderHeight ladderHeight = LadderHeight.from(height);

        // then
        assertThat(ladderHeight)
                .extracting("value")
                .isEqualTo(expected);
    }

    @DisplayName("1 이상이 아니라면 예외를 발생시킨다.")
    @Test
    void minHeightExceptionTest() {
        assertThatThrownBy(() -> LadderHeight.from("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
