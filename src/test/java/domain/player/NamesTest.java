package domain.player;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NamesTest {

    @DisplayName("정상적인 Names 객체가 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThatNoException()
                .isThrownBy(() -> new Names(List.of("파랑", "조앤")));
    }

    @DisplayName("두 명 이하로 구성된 Names 객체를 생성하려 하면 예외가 발생한다.")
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

    @DisplayName("중복된 이름을 사용하면 예외가 발생한다.")
    @Test
    void constructFailWithDuplicatedName() {
        assertThatThrownBy(() -> new Names(List.of("파랑", "파랑")));
    }
}
