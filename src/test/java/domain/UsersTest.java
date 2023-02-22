package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {

    private final List<String> testUsersName = List.of("pobi", "crong");
    private final Users users = new Users(testUsersName);

    @Test
    @DisplayName("유저의 수가 0이 들어오는 경우")
    void usersNumberIsZeroTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Users(Collections.emptyList()));
    }

    @Test
    @DisplayName("정상적으로 Users가 생성되면 해당 Users는 입력된 User들을 가진다.")
    void generateUsersTest() {
        List<String> usersName = users.getUsersName();
        Assertions.assertEquals(testUsersName, usersName);
    }

    @Test
    @DisplayName("유저의 수를 반환하는 메서드 테스트")
    void getUsersNumberTest() {
        int usersNumber = testUsersName.size();
        assertThat(users.size()).isEqualTo(usersNumber);
    }

    @Test
    @DisplayName("입력된 유저가 참여하는 유저라면 정상 진행한다.")
    void isExistSuccessTest() {
        String existUserName = "pobi";
        Assertions.assertDoesNotThrow(() -> users.isExist(existUserName));
    }

    @Test
    @DisplayName("입력된 유저가 참여하는 유저가 아니라면 예외 처리한다.")
    void ixExistFailTest() {
        String notExistUserName = "honux";
        Assertions.assertThrows(IllegalArgumentException.class, () -> users.isExist(notExistUserName));
    }
}
