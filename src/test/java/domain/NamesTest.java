package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import domain.player.Names;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(Lifecycle.PER_CLASS)
class NamesTest {
    @DisplayName("이름의 수는 2명 이상 100명 이하이다.")
    @ParameterizedTest
    @MethodSource("generateValidNames")
    void validNamesTest(List<String> names) {
        Assertions.assertDoesNotThrow(() -> new Names(names));
    }

    Stream<Arguments> generateValidNames() {
        return Stream.of(
                Arguments.arguments(List.of("깃짱", "제리", "이리내", "제나")),
                Arguments.arguments(List.of("깃짱", "제리"))
        );
    }

    @DisplayName("2명 미만 100명 초과의 이름 수는 예외 처리한다.")
    @ParameterizedTest
    @MethodSource("generateInvalidNames")
    void invalidNamesTest(List<String> names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names(names));
    }

    Stream<Arguments> generateInvalidNames() {
        return Stream.of(
                Arguments.arguments(List.of("깃짱")),
                Arguments.arguments(List.of("제리"))
        );
    }


    @Test
    void validDuplicateNamesTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names(new ArrayList<>(List.of("깃짱", "깃짱", "제리"))));
    }

}
