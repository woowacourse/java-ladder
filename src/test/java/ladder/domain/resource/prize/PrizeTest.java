package ladder.domain.resource.prize;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @DisplayName("상품의 이름의 길이가 1글자 미만인 경우 예외가 발생한다.")
    @Test
    void newPrizeTestByUnderLength() {
        //given
        String prizeName = "";

        //when, then
        assertThatThrownBy(() -> new Prize(prizeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 상품 이름의 길이는 1~5글자여야 합니다.");
    }

    @DisplayName("상품의 이름의 길이가 5글자 초과인 경우 예외가 발생한다.")
    @Test
    void newPrizeTestByOverLength() {
        //given
        String prizeName = "123456";

        //when, then
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
