package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.ErrorMessage;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsersTest {
    private final List<String> testUserNames = List.of("썬샷", "홍실");

    @Test
    @DisplayName("유저의 수가 0이 들어오는 경우")
    void usersNumberIsZero() {
        assertThatThrownBy(() -> new Users(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.USERS_NAME_BLANK_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("정상적으로 Users가 생성되는 경우")
    void generateUsersTest() {
        Assertions.assertDoesNotThrow(() -> new Users(testUserNames));
    }

    @Test
    @DisplayName("유저의 수를 반환하는 메서드 테스트")
    void getUsersNumberTest() {
        final Users users = new Users(testUserNames);
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("유저의 이름들을 반환하는 메서드 테스트")
    void getUsersNameTest() {
        final Users users = new Users(testUserNames);
        assertThat(users.getUserNames()).containsExactlyElementsOf(testUserNames);
    }

    @Test
    @DisplayName("입력한 사용자와 동일한 이름을 가진 객체가 없는 경우 예외처리")
    void throwExceptionIfCantFindUser() {
        final Users users = new Users(testUserNames);
        assertThatThrownBy(() -> users.validateParticipateUser("다니"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.USER_NOT_FOUND_EXCEPTION.getMessage());
    }

}
