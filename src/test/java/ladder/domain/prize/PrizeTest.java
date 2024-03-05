package ladder.domain.prize;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.util.BaseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {

    @DisplayName("실행 결과의 이름의 길이가 1글자 미만 5글자 초과인 경우 예외가 발생한다.")
    @ParameterizedTest()
    @ValueSource(strings = {"", "Iphone"})
    void newPrizeTestByLength(String prizeName) {
        //when, then
        assertThatThrownBy(() -> new Prize(prizeName))
                .isInstanceOf(BaseException.class)
                .hasMessage("[ERROR] 실행 결과의 이름의 길이는 1~5글자여야 합니다.");
    }

    @DisplayName("실행 결과의 이름이 한글 또는 영문 대소문자 또는 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"맥북!", "맥.북", "맥~북", "s-24", "갤24~", "갤 24."})
    void newPrizeTestByNameFormat(String prizeName) {
        //when, then
        assertThatThrownBy(() -> new Prize(prizeName))
                .isInstanceOf(BaseException.class)
                .hasMessage("[ERROR] 실행결과의 이름은 한글, 영문 대소문자, 숫자만 허용합니다.");
    }

    @DisplayName("실행 결과의 이름 내에 공백이 존재한다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "맥 북", "아이 폰"})
    void newPrizeTestByContainsBlank(String prizeName) {
        //when, then
        assertThatThrownBy(() -> new Prize(prizeName))
                .isInstanceOf(BaseException.class)
                .hasMessage("[ERROR] 실행 결과의 이름 내에는 공백을 허용하지 않습니다.");
    }
}
