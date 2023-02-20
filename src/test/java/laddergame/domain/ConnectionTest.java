package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static laddergame.domain.Connection.*;
import static org.assertj.core.api.Assertions.assertThat;

class ConnectionTest {

    @ParameterizedTest
    @MethodSource("createOverlapParameters")
    @DisplayName("Connection이 연속으로 이어져 있으면 true를 반환하고 아닌 경우에는 false를 반환한다.")
    void givenConnection_thenJudgeWhetherOverlap(
            Connection frontConnection,
            Connection behindConnection,
            boolean result
    ) {
        // when
        final boolean isOverlap = frontConnection.isOverlap(behindConnection);

        // then
        assertThat(isOverlap).isEqualTo(result);
    }

    private static Stream<Arguments> createOverlapParameters() {
        return Stream.of(
                Arguments.of(CONNECTED, CONNECTED, true),
                Arguments.of(UNCONNECTED, CONNECTED, false),
                Arguments.of(CONNECTED, UNCONNECTED, false),
                Arguments.of(UNCONNECTED, UNCONNECTED, false)
        );
    }
}
