package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderTest {
    static Stream<Arguments> Row_리스트_데이터() {
        return Stream.of(
                Arguments.of(List.of(
                        Row.of(List.of(Step.Y, Step.N)),
                        Row.of(List.of(Step.N, Step.Y))
                ))
        );
    }

    @ParameterizedTest(name = "Row 생성 성공")
    @MethodSource("Row_리스트_데이터")
    public void 생성_success(List<Row> rows) {
        assertThatNoException()
                .isThrownBy(() -> new Ladder(rows));
    }
}
