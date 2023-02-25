package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    @DisplayName("유저가 제대로 생성되면 입력된 이름을 가지고 있는지 확인")
    void generateUserTest() {
        String validUserName = "pobi";
        User user = new User(validUserName);
        String userName = user.getName();
        Assertions.assertEquals(validUserName, userName);
    }

    @Test
    @DisplayName("유저의 이름은 5글자 초과 시 예외를 반환한다.")
    void userNameOver5Test() {
        String longUserName = "pobicrong";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(longUserName));
    }

    @Test
    @DisplayName("유저의 이름이 공백이면 예외를 반환한다.")
    void userNameBlankTest() {
        String blankUserName = " ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(blankUserName));
    }

    @Test
    @DisplayName("유저의 이름이 'all'이면 예외를 반환한다.")
    void userNameIsAllTest() {
        String allUserName = "all";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(allUserName));
    }

}
