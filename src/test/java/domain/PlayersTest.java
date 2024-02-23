package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PlayersTest {

    static Stream<Arguments> createSuccessArguments() {
        return Stream.of(
                Arguments.arguments(
                        List.of("pobi", "tommy"),
                        List.of("pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi"))
        );
    }

    static Stream<Arguments> createFailArguments() {
        return Stream.of(
                Arguments.arguments(
                        List.of("pobi"),
                        List.of("pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi",
                                "pobi"))
        );
    }

    @DisplayName("2명 이상 10명 이하인 경우 예외가 발생하지않는다,")
    @ParameterizedTest
    @MethodSource("createSuccessArguments")
    public void createSuccess(List<String> names) {
        assertThatCode(() -> new Players(names))
                .doesNotThrowAnyException();
    }

    @DisplayName("2명 미만, 10명 초과하면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("createFailArguments")
    public void createFail(List<String> names) {
        assertThatCode(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("2명 이상, 10명 이하인 인원만 입력해주세요. 입력한 인원 : %d", names.size()));
    }
}
