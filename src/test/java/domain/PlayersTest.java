package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PlayersTest {
    static Stream<Arguments> createFailArguments() {
        return Stream.of(
                Arguments.arguments(
                        List.of("pobi"),
                        new ArrayList<>(Collections.nCopies(11, "asd")))
        );
    }

    @DisplayName("2명 미만, 10명 초과하면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("createFailArguments")
    public void createFailRange(List<String> players) {
        assertThatCode(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복이 존재하면 예외를 발생시킨다.")
    @Test
    public void createFailHasDuplication() {
        assertThatCode(() -> new Players(List.of(
                "wiib", "wiib", "lee")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("2명 이상 10명 이하인 경우, 중복이 없을 경우 예외가 발생하지않는다,")
    @Test
    public void createSuccess() {
        assertThatCode(() -> new Players(List.of(
                "pobi", "wiib", "lee")))
                .doesNotThrowAnyException();
    }
}
