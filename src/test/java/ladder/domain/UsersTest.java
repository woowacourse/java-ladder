package ladder.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {

    @Test
    @DisplayName("정상 Users 생성 테스트")
    void checkValidUsersTest() {
        List<String> users = List.of("가", "가나", "가나다");
        Users testUsers = new Users(users);
        assertThat(testUsers.getUsers().size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("비정상 유저이름 입력시 Users 예외 테스트")
    void invalidUsersTest() {
        List<String> users = List.of("가나", "여섯자리이름");
        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유저 이름 길이는 공백이거나 6 이상일 수 없습니다.");

    }

    @Test
    @DisplayName("중복된 유저 입력시 Users 예외 테스트")
    void invalidDuplicationUsersTest() {
        List<String> users = List.of("가나", "가나");
        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("단일 유저 입력시 Users 예외 테스트")
    void makeOneUserUsersTest() {
        List<String> users = List.of("가나");
        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유저는 한명보다 많아야 합니다.");
    }

    @Test
    @DisplayName("유저의 이름을 입력하면 해당 유저가 몇 번째 유저인지 알려준다.")
    void getUsersOrderTest() {
        final Users users = new Users(List.of("a", "b", "c"));
        assertThat(users.getOrderByName("a")).isEqualTo(0);
    }

    @Test
    @DisplayName("없는 유저 이름을 Users에서 찾으려 한다면 예외가 발생한다.")
    void getUserOrderExceptionTest() {
        final Users users = new Users(List.of("a", "b", "c"));
        assertThatThrownBy(() -> {
            users.getOrderByName("없는 이름");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 유저는 존재하지 않습니다.");
    }
}
