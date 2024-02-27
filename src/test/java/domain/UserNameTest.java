package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"rushrush", "paperp", "pobipobipo"})
    @DisplayName("사용자 이름이 5글자 이하면 예외가 발생한다")
    void userNameLengthTest(String userName) {
        assertThatThrownBy(() -> new UserName(userName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("사용자 이름은 비어 있으면 예외가 발생한다")
    void userNameEmptyTest(String userName) {
        assertThatThrownBy(() -> new UserName(userName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"종이러쉬", "!!#", "\uD83D\uDE03\uD83D"})
    @DisplayName("사용자 이름에 영문이 아닌 문자가 포함되면 예외가 발생한다")
    void userNameSpecialCharacter(String userName) {
        assertThatThrownBy(() -> new UserName(userName)).isInstanceOf(IllegalArgumentException.class);
    }
}
