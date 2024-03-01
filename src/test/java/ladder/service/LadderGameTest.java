package ladder.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.IntStream;
import ladder.model.Ladder;
import ladder.model.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameTest {
    @ParameterizedTest
    @DisplayName("사다리의 폭이 참여자 수와 다르다면 예외가 발생한다.")
    @CsvSource(value = {"3,3,2", "2,2,3"})
    void throwsExceptionIfPlayerCountAndLadderWidthDoesNotMatch(int playerCount, int rewardCount, int ladderWidth) {
        Players players = Players.from(
                IntStream.range(0, playerCount)
                        .mapToObj(i -> "P" + i)
                        .toList()
        );
        List<String> rewards = IntStream.range(0, rewardCount)
                .mapToObj(i -> "Reward_" + i)
                .toList();
        int ladderHeight = 5;
        Ladder ladder = Ladder.of(ladderHeight, ladderWidth);

        assertThatThrownBy(() -> LadderGame.from(players, rewards, ladder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("실행 결과(Reward)의 총 개수가 참여자 수와 다르다면 예외가 발생한다.")
    @CsvSource(value = {"3,2,3", "2,3,2"})
    void throwsExceptionIfPlayerCountAndRewardCountDoesNotMatch(int playerCount, int rewardCount, int ladderWidth) {
        Players players = Players.from(
                IntStream.range(0, playerCount)
                        .mapToObj(i -> "P" + i)
                        .toList()
        );
        List<String> rewards = IntStream.range(0, rewardCount)
                .mapToObj(i -> "Reward_" + i)
                .toList();
        int ladderHeight = 5;
        Ladder ladder = Ladder.of(ladderHeight, ladderWidth);

        assertThatThrownBy(() -> LadderGame.from(players, rewards, ladder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사다리 폭, 실행 결과, 참여자 수가 모두 일치하면 LadderGame을 생성할 수 있다.")
    @CsvSource(value = {"3,3,3", "2,2,2"})
    void ladderGameCreationTest(int playerCount, int rewardCount, int ladderWidth) {
        Players players = Players.from(
                IntStream.range(0, playerCount)
                        .mapToObj(i -> "P" + i)
                        .toList()
        );
        List<String> rewards = IntStream.range(0, rewardCount)
                .mapToObj(i -> "Reward_" + i)
                .toList();
        int ladderHeight = 5;
        Ladder ladder = Ladder.of(ladderHeight, ladderWidth);

        assertThatCode(() -> LadderGame.from(players, rewards, ladder))
                .doesNotThrowAnyException();
    }
}
