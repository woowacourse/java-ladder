package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class UsersTest {

    @Test
    @DisplayName("정상 Users 생성 테스트")
    void checkValidUsersTest() {

        List<String> users = List.of("가", "가나", "가나다");

        assertThatCode(() -> new Users(users))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("중복된 유저 입력시 Users 예외 테스트")
    void invalidDuplicationUsersTest() {

        List<String> users = List.of("가나", "가나");

        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("단일 유저 입력시 Users 예외 테스트")
    void makeOneUserUsersTest() {

        List<String> users = List.of("가나");

        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("명 미만");
    }

    @Test
    @DisplayName("Users를 생성할 때 각 user에 순차적인 x위치값을 초기화한다.")
    void initUsersPosition() {

        //given
        List<String> userNames = List.of("user1", "user2", "user3");

        //when
        Users users = new Users(userNames);
        List<Integer> result = users.getUsers().stream()
                .map(User::getxPosition)
                .collect(Collectors.toList());

        //then
        assertThat(result)
                .containsExactly(0, 1, 2);
    }
}
