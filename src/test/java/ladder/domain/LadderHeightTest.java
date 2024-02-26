package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    @DisplayName("숫자가 아니면 예외를 발생시킨다.")
    void numericHeightExceptionTest() {
        assertThatThrownBy(() -> LadderHeight.from("one"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 숫자이어야 합니다.");

    }

    @DisplayName("1 미만이라면 예외를 발생시킨다.")
    @Test
    void minHeightExceptionTest() {
        assertThatThrownBy(() -> LadderHeight.from("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 1 이상의 정수이어야 합니다.");
    }

    @DisplayName("사다리 높이 양쪽에 공백이 있는 경우 제거 한다.")
    @ParameterizedTest
    @ValueSource(strings = {" 10", " 10 ", "10 "})
    void heightStripTest(String height) {
        // given
        int expected = 10;

        // when
        LadderHeight ladderHeight = LadderHeight.from(height);

        // then
        assertThat(ladderHeight)
                .extracting("value")
                .isEqualTo(expected);
    }
}
