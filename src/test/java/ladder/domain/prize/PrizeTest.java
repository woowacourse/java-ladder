package ladder.domain.prize;

import ladder.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @DisplayName("실행 결과의 이름의 길이가 1글자 미만 5글자 초과인 경우 예외가 발생한다.")
    @ParameterizedTest()
    @ValueSource(strings = {"", "Iphone"})
    void newPrizeTestByLength(String prizeName) {
        //when, then
        assertThatThrownBy(() -> new Prize(prizeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자 이름의 길이는 1~5글자여야 합니다.");
    }
}