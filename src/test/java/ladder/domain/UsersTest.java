package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
    @DisplayName("users 일급 컬렉션의 contain 테스트")
    void containTest() {
        var users = new Users(List.of("nameA", "nameB", "nameC"));

        assertThat(users.contain("nameB")).isTrue();
        assertThat(users.contain("nameD")).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:user1", "1:user2", "2:user3"}, delimiter = ':')
    @DisplayName("파라미터 인덱스에 해당하는 유저 이름을 반환한다.")
    void getUserNameByIndex(int index, String name) {
        var users = new Users(List.of("user1", "user2", "user3"));

        String userNameByIndex = users.getUserNameByIndex(index);

        assertThat(userNameByIndex).isEqualTo(name);
    }
}
