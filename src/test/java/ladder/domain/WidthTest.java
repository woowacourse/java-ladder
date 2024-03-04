package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import ladder.domain.ladder.Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WidthTest {
    @DisplayName("입력된 인자를 value로 가진다.")
    @Test
    void widthConstructTest() {
        Width width = new Width(2);

        assertThat(width.value()).isEqualTo(2);
    }

    @DisplayName("2 미만의 너비를 입력하면 예외가 발생한다.")
    @ValueSource(ints = {1, 0, -1})
    @ParameterizedTest
    void invalidWidthTest(int value) {
        assertThatThrownBy(() -> new Width(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("너비는 2 이상이여야 합니다: %d".formatted(value));
    }

    @DisplayName("값만큼 입력된 함수를 반복 실행하여 리스트를 생성한다.")
    @Test
    void repeatTest() {
        Width width = new Width(5);

        List<Integer> intList = width.repeat(() -> 0);

        assertThat(intList.size()).isEqualTo(5);
    }
}
