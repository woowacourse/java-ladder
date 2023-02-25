package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest(name = "높이는 1이상, 100이하의 값이 아닌 경우 예외를 던진다. 입력값: \"{0}\"")
    @ValueSource(strings = {"0", "-1", "101", "!", "백"})
    void 높이는_올바른_입력값이_아니라면_예외를_던진다(final String value) {
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이는 1이상, 100이하의 값이어야 합니다.");
    }

    @ParameterizedTest(name = "높이가 정상적으로 생성된다. 입력값: {0}")
    @ValueSource(strings = {"1", "100"})
    void 높이가_정상적으로_생성된다(final String value) {
        final Height height = new Height(value);

        assertThat(height.getValue()).isEqualTo(Integer.parseInt(value));
    }
}
