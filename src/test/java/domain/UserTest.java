package domain;

import static domain.ErrorMessages.CONFLICT_NAME;
import static domain.ErrorMessages.NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {
    @ParameterizedTest(name = "이름이 1글자 이상 5글자 이하면 User를 생성한다. 입력값 = {0}")
    @ValueSource(strings = {"pobi", "honux", "jk"})
    void userSuccessTest(String name) {
        assertThatCode(() -> new User(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "이름이 1글자 미만 5글자 초과면 예외를 던진다. 입력값 = {0}")
    @ValueSource(strings = {"", "honuxx"})
    void userFailureTest(String name) {
        assertThatThrownBy(() -> new User(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_LENGTH.getMessage());
    }

    @ParameterizedTest(name = "이름이 일치하면 true를 반환하고, 일치하지 않으면 false를 반환한다..")
    @CsvSource({"pobi,true", "polo,false"})
    void isEqualTest(String userName, boolean expected) {
        User pobi = new User("pobi");

        boolean result = pobi.equals(new User(userName));

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "QUIT 또는 ALL 은 사용자의 이름으로 사용할 수 없습니다. 입력값 = {0}")
    @ValueSource(strings = {"ALL", "QUIT"})
    void conflictNameUserTest(String conflictName) {
        assertThatThrownBy(() -> new User(conflictName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CONFLICT_NAME.getMessage());
    }
}
