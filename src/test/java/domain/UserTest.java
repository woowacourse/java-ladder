package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.user.User;
import exception.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("유저가 제대로 생성되는지 확인")
    void userTest() {
        Assertions.assertDoesNotThrow(() -> new User("홍실"));
    }

    @Test
    @DisplayName("유저가 이름은 5글자 이하여야한다.")
    void userName5overTest() {
        assertThatThrownBy(() -> new User("홍실썬샷페어"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.USER_NAME_LENGTH_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("유저의 이름이 공백인지 확인")
    void userNameBlankTest() {
        assertThatThrownBy(() -> new User(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.USER_NAME_BLANK_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("유저의 이름을 반환하는 메서드 테스트")
    void getUserNameTest() {
        String userName = "썬샷";
        User user = new User(userName);
        assertThat(user.getName())
                .isEqualTo(userName);
    }

    @Test
    @DisplayName("User와 동일한 이름을 파라미터로 넘기면 true")
    void isSameNameTrueTest() {
        final User user = new User("홍실");
        assertThat(user.isSameName("홍실")).isTrue();
    }

    @Test
    @DisplayName("User와 다른 이름을 파라미터로 넘기면 false")
    void isSameNameFalseTest() {
        final User user = new User("홍실");
        assertThat(user.isSameName("다니")).isFalse();
    }

    @Test
    @DisplayName("User의 이름에 all이 들어오는 경우 예외처리")
    void throwExceptionWhenUserNameIsAll() {
        assertThatThrownBy(() -> new User("all"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.USER_NAME_IS_ALL_EXCEPTION.getMessage());
    }
}
