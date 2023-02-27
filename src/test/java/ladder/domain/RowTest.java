package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class RowTest {
    @Test
    @DisplayName("발판이 가로로 연속적이면 예외가 발생한다")
    public void 생성_fail_연속발판() {
        assertThatThrownBy(() -> Row.of(List.of(Step.Y, Step.Y)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로로 연속된 발판은 만들 수 없습니다.");
    }

    @ParameterizedTest(name = "발판이 가로로 {0}, {1}이면 정상 생성된다")
    @CsvSource({"Y,N", "N,N"})
    public void 생성_success(Step first, Step second) {
        assertThatNoException()
                .isThrownBy(() -> Row.of(List.of(first, second)));
    }

    @ParameterizedTest(name = "양옆 index에 발판이 없는 경우에만 발판을 생성할 수 있다")
    @MethodSource("발판_생성_가능_여부_판단_데이터")
    public void 발판_생성_가능_여부_판단(Row row, int targetIndex, boolean expected) {
        assertThat(row.isPossibleInstallStep(targetIndex)).isEqualTo(expected);
    }

    static Stream<Arguments> 발판_생성_가능_여부_판단_데이터() {
        return Stream.of(
                Arguments.of(Row.of(List.of(Step.Y, Step.N)), 1, false),
                Arguments.of(Row.of(List.of(Step.N, Step.N, Step.Y)), 0, true),
                Arguments.of(Row.of(List.of(Step.N, Step.N, Step.Y)), 1, false)
        );
    }
}
