package ladder.domain.prize;

import ladder.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeTest {

    @DisplayName("실행 결과의 이름의 길이가 1글자 미만 5글자 초과인 경우 예외가 발생한다.")
    @ParameterizedTest()
    @ValueSource(strings = {"", "Iphone"})
    void newPrizeTestByLength(String prizeName) {
        //when, then
        assertThatThrownBy(() -> new Prize(prizeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 실행 결과의 이름의 길이는 1~5글자여야 합니다.");
    }

    @DisplayName("실행 결과의 이름 내에 공백이 존재한다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "맥 북", "아이 폰"})
    void newPrizeTestByContainsBlank(String prizeName) {
        //when, then
        assertThatThrownBy(() -> new Prize(prizeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 실행 결과의 이름 내에는 공백을 허용하지 않습니다.");
    }
}
