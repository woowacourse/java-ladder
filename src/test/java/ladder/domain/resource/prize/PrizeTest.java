package ladder.domain.resource.prize;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {

    @DisplayName("상품의 이름의 길이가 1~5글자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void newPrizeTestByOutOfLength(String prizeName) {
        //given, when, then
        assertThatThrownBy(() -> new Prize(prizeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 상품 이름의 길이는 1~5글자여야 합니다.");
    }

    @DisplayName("상품의 이름 내에 공백이 존재한다면 예외가 발생한다.")
    @Test
    void newPrizeTestByContainsBlank() {
        //given
        String prizeName = "꽝 ";

        //when, then
        assertThatThrownBy(() -> new Prize(prizeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 상품 이름 내에는 공백을 허용하지 않습니다.");
    }
}
