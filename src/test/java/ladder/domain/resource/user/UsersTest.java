package ladder.domain.resource.user;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UsersTest {

    @DisplayName("사용자의 이름의 개수가 2~10이 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    void newUsersTestByOutOfSize(int count) {
        //given
        List<User> users = generateUsers(count);

        // when, then
        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자는 2~10명 까지만 등록 가능합니다.");
    }

    @DisplayName("사용자의 이름이 중복된다면 예외로 처리한다.")
    @Test
    void newUsersTestByDuplicatedUserName() {
        //given
        List<User> users = List.of(new User("ted"),
                new User("mason"),
                new User("ted"));

        //when, then
        assertThatThrownBy(() -> new Users(users))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 사용자명이 존재합니다.");
    }

    private List<User> generateUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(new User("u" + i));
        }

        return users;
    }
}
