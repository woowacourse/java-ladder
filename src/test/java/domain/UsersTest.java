package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsersTest {
    @DisplayName("중복된 유저가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("usersSameNameFailParameter")
    void usersSameNameFailTest(List<User> input) {
        assertThatThrownBy(() -> new Users(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @DisplayName("입력된 유저의 수가 1~10명 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("usersFailParameter")
    void usersSizeFailTest(List<User> input) {
        assertThrows(IllegalArgumentException.class, () -> new Users(input));
    }

    @DisplayName("입력된 유저의 수가 1~10명 사이이면 정상적으로 수행된다.")
    @ParameterizedTest
    @MethodSource("usersSuccessParameter")
    void usersSizeSuccessTest(List<User> input) {
        assertThatCode(() -> new Users(input)).doesNotThrowAnyException();
    }

    static Stream<Arguments> usersSameNameFailParameter() {
        List<User> names = new ArrayList<>(Collections.nCopies(5, new User("power")));

        return Stream.of(Arguments.of(names));
    }

    static Stream<Arguments> usersFailParameter() {
        return Stream.of(Arguments.of(List.of(new User("power"))),
                Arguments.of(List.of(new User("aa")
                        , new User("bb")
                        , new User("cc")
                        , new User("dd")
                        , new User("ee")
                        , new User("ff")
                        , new User("gg")
                        , new User("hh")
                        , new User("ii")
                        , new User("jj")
                        , new User("kk")
                )));
    }

    static Stream<Arguments> usersSuccessParameter() {
        return Stream.of(Arguments.of(List.of(new User("aa"), new User("bb"))),
                Arguments.of(List.of(new User("aa"), new User("bb"), new User("cc"), new User("dd"), new User("ee"))));
    }
}
