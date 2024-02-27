package ladder.domain.user;

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
                .hasMessage("[ERROR] 사용자 이름의 길이는 1~5글자여야 합니다.");
    }

    @DisplayName("사용자의 이름의 길이가 5글자 초과인 경우 예외가 발생한다.")
    @Test
    void newUserTestByOverLength() {
        //given
        String userName = "abcdef";

        //when, then
        assertThatThrownBy(() -> new User(userName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자 이름의 길이는 1~5글자여야 합니다.");
    }

    @DisplayName("사용자의 이름이 영문 대소문자가 아닌 경우 예외가 발생한다.")
    @Test
    void newUserTestByEngFormat() {
        //given
        String userName = "메이슨";

        //when, then
        assertThatThrownBy(() -> new User(userName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자 이름은 영문 대소문자만 허용합니다.");
    }

    @DisplayName("사용자의 이름 내에 공백이 존재한다면 예외가 발생한다.")
    @Test
    void newUserTestByContainsBlank() {
        //given
        String userName = "te d";

        //when, then
        assertThatThrownBy(() -> new User(userName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자 이름 내에는 공백을 허용하지 않습니다.");
    }
}
