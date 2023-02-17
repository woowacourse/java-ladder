package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {
    private final List<String> testUsersName = List.of("썬샷", "홍실");

    @Test
    @DisplayName("유저의 수가 0이 들어오는 경우")
    void usersNumberIsZeroTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Users(Collections.emptyList()));
    }

    @Test
    @DisplayName("정상적으로 Users가 생성되는 경우")
    void generateUsersTest() {
        Assertions.assertDoesNotThrow(() -> new Users(testUsersName));
    }

    @Test
    @DisplayName("유저의 수를 반환하는 메서드 테스트")
    void getUsersNumberTest() {
        int usersNumber = testUsersName.size();
        Users users = new Users(testUsersName);
        assertThat(users.size()).isEqualTo(usersNumber);
    }
}
