package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class UsersTest {
    @DisplayName("입력된 유저의 수가 1~10명 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("usersFailParameter")
    void usersSizeFailTest(List<User> input) {
        assertThatThrownBy(() -> new Users(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 유저의 수가 1~10명 사이이면 정상적으로 수행된다.")
    @ParameterizedTest
    @MethodSource("usersSuccessParameter")
    void usersSizeSuccessTest(List<User> input) {
        assertThatCode(() -> new Users(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임에 참여한 유저이름을 검색하면 true, 그렇지 않으면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi,true", "leo,false"})
    void userContainsTest(String userName, boolean result) {
        Users users = new Users(new ArrayList<>(
                List.of(
                        new User("pobi"),
                        new User("crong"),
                        new User("honux"),
                        new User("jk")))
        );

        assertThat(users.contain(userName)).isEqualTo(result);
    }

    static Stream<Arguments> usersFailParameter() {
        List<User> names = new ArrayList<>(
                Collections.nCopies(11, new User("power"))
        );

        return Stream.of(
                Arguments.of(List.of(new User("power"))),
                Arguments.of(names)
        );
    }

    static Stream<Arguments> usersSuccessParameter() {
        List<User> names = new ArrayList<>(
                Collections.nCopies(10, new User("power"))
        );

        return Stream.of(
                Arguments.of(List.of(new User("power"), new User("power"))),
                Arguments.of(names)
        );
    }
}
