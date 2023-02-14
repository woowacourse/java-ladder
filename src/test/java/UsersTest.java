import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class UsersTest {
    @DisplayName("입력된 유저의 수가 1~10명 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("usersFailParameter")
    void usersSizeFailTest(List<String> input) {
        System.out.println(input);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Users(input));
    }

    @DisplayName("입력된 유저의 수가 1~10명 사이이면 정상적으로 수행된다.")
    @ParameterizedTest
    @MethodSource("usersSuccessParameter")
    void usersSizeSuccessTest(List<String> input) {
        assertThatCode(() -> new Users(input)).doesNotThrowAnyException();
    }

    static Stream<Arguments> usersFailParameter() {
        List<String> names = new ArrayList<>(
                Collections.nCopies(11, "power")
        );

        return Stream.of(
                Arguments.of(List.of("power")),
                Arguments.of(names)
        );
    }

    static Stream<Arguments> usersSuccessParameter() {
        List<String> names = new ArrayList<>(
                Collections.nCopies(10, "power")
        );

        return Stream.of(
                Arguments.of(List.of("power", "power")),
                Arguments.of(names)
        );
    }
}
