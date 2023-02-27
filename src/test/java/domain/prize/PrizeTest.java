package domain.prize;

import domain.prize.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PrizeTest {

    @DisplayName("각 사다리 게임의 실행 결과가 1글자에서 5글자 사이로 입력되는 경우에는 Prize가 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "꽝"})
    void prizeValidateTest1(String input) {
        assertThatCode(() -> new Prize(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("각 사다리 게임의 실행 결과가 1글자에서 5글자 사이로 입력되지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"500000", "", "100 00"})
    void prizeValidateTest2(String input) {
        Assertions.assertThatThrownBy(() -> new Prize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임의 실행 결과는 1글자에서 5글자 사이로 입력해야합니다.");
    }

    @DisplayName("각 사다리 게임의 실행 결과의 앞 뒤에 공백이 있는 경우에는 이를 포함하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"   5000", "1000   ", "    꽝   "})
    void prizeValidateTest3(String input) {
        assertThatCode(() -> new Prize(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임의 실행 결과의 이름이 동일하면 동일한 실행 결과이다.")
    @Test
    void prizeEqualsTest() {
        String prizeName = "꽝";
        Prize prize1 = new Prize(prizeName);
        Prize prize2 = new Prize(prizeName);
        assertThat(prize1).isEqualTo(prize2);
    }
}
