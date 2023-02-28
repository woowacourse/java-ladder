package domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PrizesTest {

    @ParameterizedTest
    @MethodSource("createRightPrizes")
    @DisplayName("1개 이상의 결과가 입력되면 Prizes가 생성된다.")
    void createPrizesSuccess(List<String> inputPrizes) {
        Prizes prizes = new Prizes(inputPrizes);

        assertThat(prizes.getPrizes()).isEqualTo(inputPrizes);
    }

    @ParameterizedTest
    @MethodSource("createWrongPrizes")
    @DisplayName("결과가 최소 2개 이상 입력되지 않으면 예외가 발생한다.")
    void createPrizesFail(List<String> inputPrizes) {
        assertThatThrownBy(() -> new Prizes(inputPrizes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 2개 이상의 결과가 존재해야 합니다.");
    }

    @Test
    @DisplayName("결과명에 blank가 존재하는 경우 예외가 발생한다.")
    void createPrizesWithBlankString() {
        List<String> inputPrizes = List.of(" ", "1000원", "5000원");

        assertThatThrownBy(() -> new Prizes(inputPrizes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과명에는 빈 문자열과 공백이 허용되지 않습니다.");
    }

    static Stream<Arguments> createRightPrizes() {
        return Stream.of(
                Arguments.arguments(List.of("10000원", "꽝", "5000원")),
                Arguments.arguments(List.of("1000원", "꽝", "꽝", "20000원")),
                Arguments.arguments(List.of("꽝", "꽝"))
        );
    }

    static Stream<Arguments> createWrongPrizes() {
        return Stream.of(
                Arguments.arguments(List.of()),
                Arguments.arguments(List.of(" ")),
                Arguments.arguments(List.of("1000원"))
        );
    }
}
