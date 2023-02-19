package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class ItemsTest {
    @DisplayName("입력된 결과값 개수가 유저수와 다르면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("resultFailParameter")
    void usersSizeFailTest(List<Item> input) {
        Users users = new Users(List.of(new User("aa"), new User("bb"), new User("cc")));

        assertThatThrownBy(() -> new Items(input, users))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> resultFailParameter() {
        return Stream.of(Arguments.of(List.of(new Item("aa"), new Item("bb"))),
                Arguments.of(List.of(new Item("aa"), new Item("bb"), new Item("cc"), new Item("dd"))));
    }
}
