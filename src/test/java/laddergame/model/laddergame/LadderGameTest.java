package laddergame.model.laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderGameTest {
    @DisplayName("사다리 게임을 진행하여 최종 결과 인덱스를 반환한다.")
    @ParameterizedTest
    @MethodSource("createLadderGameAndAllIndex")
    void climb(LadderGame ladderGame, List<Integer> changedIndexes) {
        assertAll(
                () -> assertThat(ladderGame.climb(0)).isEqualTo(changedIndexes.get(0)),
                () -> assertThat(ladderGame.climb(1)).isEqualTo(changedIndexes.get(1)),
                () -> assertThat(ladderGame.climb(2)).isEqualTo(changedIndexes.get(2)),
                () -> assertThat(ladderGame.climb(3)).isEqualTo(changedIndexes.get(3))
        );
    }

    private static Stream<Arguments> createLadderGameAndAllIndex() {
        return Stream.of(
                Arguments.arguments(
                        new LadderGame(List.of(
                                new Line(List.of(LineState.START, LineState.END, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.NONE, LineState.START, LineState.END, LineState.NONE))
                        )),
                        List.of(2, 0, 1, 3)
                ),
                Arguments.arguments(
                        new LadderGame(List.of(
                                new Line(List.of(LineState.START, LineState.END, LineState.START, LineState.END)),
                                new Line(List.of(LineState.START, LineState.END, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.NONE, LineState.NONE)),
                                new Line(List.of(LineState.START, LineState.END, LineState.NONE, LineState.NONE))
                        )),
                        List.of(1, 0, 3, 2)
                ),
                Arguments.arguments(
                        new LadderGame(List.of(
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.START, LineState.END)),
                                new Line(List.of(LineState.NONE, LineState.NONE, LineState.NONE, LineState.NONE))
                        )), List.of(0, 1, 3, 2)
                )
        );
    }
}
