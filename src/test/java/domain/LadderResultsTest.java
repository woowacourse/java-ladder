package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;
import domain.ladder.LadderResults;
import domain.player.PlayerName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LadderResultsTest {

    @Nested
    @DisplayName("")
    class LadderResultsSizeTest {

        @ParameterizedTest
        @MethodSource("createLadderResultsSuccessWithSizeArguments")
        @DisplayName("사다리 실행 결과의 수가 참가자 이름의 수와 다르면 예외가 발생한다")
        void createLadderResultsSuccessWithSize(String[] ladderResults, List<PlayerName> playerNames) {
            //given
            int playerCount = playerNames.size();

            //when, then
            Assertions.assertThatCode(() -> new LadderResults(ladderResults, playerCount))
                    .doesNotThrowAnyException();
        }

        private static Stream<Arguments> createLadderResultsSuccessWithSizeArguments() {
            return Stream.of(
                    Arguments.arguments(new String[]{"R1", "R2"},
                            List.of(new PlayerName("a"), new PlayerName("b")))
            );
        }

        @ParameterizedTest
        @MethodSource("createLadderResultsFailBySizeArguments")
        @DisplayName("사다리 실행 결과의 수가 참가자 이름의 수와 다르면 예외가 발생한다")
        void createLadderResultsFailBySize(String[] ladderResults, List<PlayerName> playerNames) {
            //given
            int playerCount = playerNames.size();

            //when, then
            Assertions.assertThatThrownBy(() -> new LadderResults(ladderResults, playerCount))
                    .isInstanceOf(ValidationException.class)
                    .hasMessage(ExceptionMessage.LADDER_RESULTS_SIZE);
        }

        private static Stream<Arguments> createLadderResultsFailBySizeArguments() {
            return Stream.of(
                    Arguments.arguments(new String[]{"R1", "R2", "R3"},
                            List.of(new PlayerName("a"), new PlayerName("b")))
            );
        }

    }
}
