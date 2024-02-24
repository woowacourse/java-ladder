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
    @DisplayName("사용자 이름은 5글자 이하이다.")
    void userNameLengthTest(String userName) {
        assertThatThrownBy(() -> new UserName(userName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("사용자 이름은 비어 있을 수 없다")
    void userNameEmptyTest(String userName) {
        assertThatThrownBy(() -> new UserName(userName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi!", " rush%rush", "pa$per*"})
    @DisplayName("사용자 이름에 특수기호는 들어갈 수 없다")
    void userNameSpecialCharacter(String userName) {
        assertThatThrownBy(() -> new UserName(userName)).isInstanceOf(IllegalArgumentException.class);
    }
}
