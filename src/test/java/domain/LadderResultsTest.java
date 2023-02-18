package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderResultsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("결과의 수가 플레이어의 수와 같지 않다면 예외를 발생시킨다.")
    void throws_exception_when_results_not_matched_with_player_numbers(int playerNumber) {
        // given
        int notMatchedPlayerNumber = playerNumber - 1;

        List<LadderResult> givenLadderResults = new ArrayList<>();
        for (int i = 0; i < notMatchedPlayerNumber; i++) {
            givenLadderResults.add(new LadderResult(String.valueOf(i)));
        }

        // when && then
        assertThatThrownBy(() -> new LadderResults(givenLadderResults, playerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("결과의 수가 플레이어의 수와 같다면 예외가 발생하지 않는다.")
    void throws_not_exception_when_results_matched_with_player_numbers(int playerNumber) {
        // given
        List<LadderResult> givenLadderResults = new ArrayList<>();
        for (int i = 0; i < playerNumber; i++) {
            givenLadderResults.add(new LadderResult(String.valueOf(i)));
        }

        // when
        LadderResults ladderResults = new LadderResults(givenLadderResults, playerNumber);

        // then
        assertThat(ladderResults.getResults().size()).isEqualTo(playerNumber);
    }
}
