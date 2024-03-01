package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {
    @DisplayName("입력된 인자를 value로 가진다.")
    @Test
    void heightConstructTest() {
        Height height = new Height(1);

        assertThat(height.value()).isEqualTo(1);
    }

    @DisplayName("자연수가 아닌 높이를 입력하면 예외가 발생한다.")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void invalidHeightTest(int value) {
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이는 1 이상이여야 합니다: %d".formatted(value));
    }

    @DisplayName("값만큼 입력된 함수를 반복 실행하여 리스트를 생성한다.")
    @Test
    void repeatTest() {
        Height height = new Height(5);

        List<Integer> intList = height.repeat(() -> 0);

        assertThat(intList.size()).isEqualTo(5);
    }
}
