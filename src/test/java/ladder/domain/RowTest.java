package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RowTest {
    @Test
    @DisplayName("발판이 가로로 연속적이면 예외가 발생한다")
    public void 생성_fail_연속발판() {
        assertThatThrownBy(() -> Row.of(List.of(Foothold.Y, Foothold.Y), 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로로 연속된 발판은 만들 수 없습니다.");
    }

    @Test
    @DisplayName("width가 player수 - 1이 아니면 예외가 발생한다")
    public void 생성_fail_width사이즈() {
        assertThatThrownBy(() -> Row.of(List.of(Foothold.N, Foothold.N, Foothold.Y), 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 길이가 맞지 않습니다.");
    }

    @ParameterizedTest(name = "발판이 가로로 {0}, {1}이면 정상 생성된다")
    @CsvSource({"Y,N", "N,N"})
    public void 생성_success(Foothold first, Foothold second) {
        assertThatNoException()
                .isThrownBy(() -> Row.of(List.of(first, second), 2));
    }
}
