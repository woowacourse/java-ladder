package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {
    private List<String> testUserNames;
    private Users users;

    @BeforeEach
    void initUsersTest() {
        testUserNames = List.of("pobi", "crong");
    }

    @Test
    @DisplayName("유저의 수가 0이 들어오는 경우")
    void userNumbersIsZeroTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Users(Collections.emptyList()));
    }

    @Test
    @DisplayName("정상적으로 Users가 생성되면 해당 Users는 입력된 User들을 가진다.")
    void generateUsersTest() {
        users = new Users(testUserNames);
        List<String> userNames = users.getUserNames();
        Assertions.assertEquals(testUserNames, userNames);
    }

    @Test
    @DisplayName("유저의 수를 반환하는 메서드 테스트")
    void getUsersNumberTest() {
        users = new Users(testUserNames);
        int userNumbers = testUserNames.size();
        assertThat(users.size()).isEqualTo(userNumbers);
    }

    @Test
    @DisplayName("입력된 유저가 참여하는 유저라면 정상 진행한다.")
    void isExistSuccessTest() {
        users = new Users(testUserNames);
        String existUserName = "pobi";
        Assertions.assertDoesNotThrow(() -> users.isExist(existUserName));
    }

    @Test
    @DisplayName("입력된 유저가 참여하는 유저가 아니라면 예외 처리한다.")
    void ixExistFailTest() {
        users = new Users(testUserNames);
        String notExistUserName = "honux";
        assertThat(users.isExist(notExistUserName)).isEqualTo(false);
    }
}
