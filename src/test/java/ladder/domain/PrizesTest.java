package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PrizesTest {
    @ParameterizedTest
    @MethodSource("기대한_사이즈가_아니면_예외던지기_데이터")
    public void 기대한_사이즈가_아니면_예외던지기(List<String> names, int expectedSize) {
        assertThatThrownBy(() -> Prizes.from(names, expectedSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("상품의 개수는 %d이어야합니다.", expectedSize));
    }

    static Stream<Arguments> 기대한_사이즈가_아니면_예외던지기_데이터() {
        return Stream.of(
                Arguments.of(List.of("aa", "bb"), 3),
                Arguments.of(List.of("1", "2", "3"), 2)
        );
    }
}
