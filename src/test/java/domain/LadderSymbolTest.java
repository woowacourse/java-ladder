package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import view.LadderSymbol;

class LadderSymbolTest {

    @ParameterizedTest
    @ValueSource(strings = {"-", " ", "|"})
    @DisplayName("Symbol에 해당하는 기호와 반복되는 횟수가 주어졌을 때, 그에 맞게 기호를 반환한다.")
    void returns_symbol_when_given_symbol_and_repeated_number(String givenSymbol) {
        // given
        int repeatedNumber = 5;

        // when
        String result = LadderSymbol.draw(givenSymbol, repeatedNumber);

        // then
        assertThat(result).isEqualTo(givenSymbol.repeat(repeatedNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    @DisplayName("Symbol에 해당하지 않는 기호와 반복되는 횟수가 주어졌을 때, 예외를 던진다.")
    void throws_exception_when_given_wrong_symbol(String givenSymbol) {
        // given
        int repeatedNumber = 3;

        // when & then
        assertThatThrownBy(() -> LadderSymbol.draw(givenSymbol, repeatedNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리를 만들기 위한 올바르지 않은 기호입니다.");
    }
}
