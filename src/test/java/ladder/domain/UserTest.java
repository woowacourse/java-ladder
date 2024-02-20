package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("사용자의 이름의 길이가 1글자 미만인 경우 예외가 발생한다.")
    @Test
    void newUserTestByUnderLength() {
        //given
        String userName = "";

        //when, then
        assertThatThrownBy(() -> new User(userName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 사용자 이름의 길이는 1~5글자여야 합니다.");
    }

    @DisplayName("사용자의 이름의 길이가 5글자 초과인 경우 예외가 발생한다.")
    @Test
    void newUserTestByOverLength() {
        //given
        String userName = "abcdef";

        //when, then
        assertThatThrownBy(() -> new User(userName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 사용자 이름의 길이는 1~5글자여야 합니다.");
    }

}