package domain.player;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NamesTest {

    @Test
    void constructSuccessTest() {
        assertThatNoException()
                .isThrownBy(() -> new Names(List.of("파랑", "조앤")));
    }

    @ParameterizedTest
    @MethodSource("getBridgeTestProvider")
    void constructFailWithNamesLessThan2(List<String> names) {
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> getBridgeTestProvider() {
        return Stream.of(
                Arguments.of(
                        List.of()
                ),
                Arguments.of(
                        List.of("조앤")
                )
        );
    }


}
