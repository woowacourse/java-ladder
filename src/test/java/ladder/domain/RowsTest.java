package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatNoException;

class RowsTest {
    static Stream<Arguments> Row_리스트_데이터() {
        return Stream.of(
                Arguments.of(List.of(
                        Row.of(List.of(Foothold.Y, Foothold.N), 2),
                        Row.of(List.of(Foothold.N, Foothold.Y), 2)
                ))
        );
    }

    @ParameterizedTest(name = "Row 생성 성공")
    @MethodSource("Row_리스트_데이터")
    public void 생성_success(List<Row> rows) {
        assertThatNoException()
                .isThrownBy(() -> new Rows(rows));
    }
}
