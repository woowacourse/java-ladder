package ladder.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class UsersTest {

    @Test
    @DisplayName("정상 Users 생성 테스트")
    void checkValidUsersTest(){
        List<String> users = List.of("가","가나","가나다");
        Users testUsers = new Users(users);
        assertThat(testUsers.getUsers().size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("비정상 유저이름 입력시 Users 예외 테스트")
    void invalidUsersTest() {
        List<String> users = List.of("가나","여섯자리이름");
        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
