package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ItemTest {
    @DisplayName("입력된 결과값 개수가 유저수와 다르면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("resultFailParameter")
    void usersSizeFailTest(List<String> input) {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> new Item(input, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> resultFailParameter() {
        return Stream.of(Arguments.of(List.of("aa", "bb")),
                Arguments.of(List.of("aa", "bb", "cc", "dd")));
    }
}
