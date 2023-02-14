import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

public class UsersTest {
    @DisplayName("입력된 유저의 수가 1~10명 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("usersParameter")
    void usersSizeFailTest(List<String> input) {
        System.out.println(input);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Users(input));
    }

    static Stream<Arguments> usersParameter() {
        List<String> names = new ArrayList<>(
                Collections.nCopies(11, "power")
        );

        return Stream.of(
                Arguments.of(List.of("power")),
                Arguments.of(names)
        );
    }
}
