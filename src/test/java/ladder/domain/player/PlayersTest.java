package ladder.domain.player;

import ladder.domain.MockRandomBooleanGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.reward.RewardName;
import ladder.domain.reward.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PlayersTest {

    /**
     * true,false
     * true,false
     **/

    private static final List<String> correctPlayerNames = List.of("pobi", "crong", "honux");
    private static final List<String> rewardNames = List.of("꽝", "성공", "실패");
    private static final Ladder ladder = new Ladder(2, 3, new MockRandomBooleanGenerator());
    private static final Players players = new Players(correctPlayerNames);
    private static final Rewards rewards = new Rewards(correctPlayerNames.size(), rewardNames);


    /**
     * true,false
     * true,false
     */
    @ParameterizedTest
    @CsvSource(value = {"pobi,꽝", "crong,성공", "honux,실패"})
    @DisplayName("각 플레이어가 예상한 대로 이동해, 해당하는 보상을 제대로 연결되었는지 확인한다")
    void findResultOfPlayersWithTest(final String player, final String reward) {
        players.movePlayers(ladder);
        final Map<PlayerName, RewardName> result = players.findResultOfPlayersWith(rewards);

        assertThat(result.get(new PlayerName(player)))
                .isEqualTo(new RewardName(reward));

    }

    @Test
    @DisplayName("플레이어 이름 리스트 반환 테스트")
    void findPlayerNames() {

        assertThat(players.findPlayerNames())
                .isEqualTo(correctPlayerNames);
    }

    @Test
    @DisplayName("플레이어의 수 반환 테스트")
    void findNumberOfPlayers() {
        assertThat(players.findNumberOfPlayers())
                .isEqualTo(correctPlayerNames.size());
    }

    /**
     *
     */
    @Nested
    @DisplayName("Players 객체를 생성할 때, ")
    class PlayersInitiator {

        @Test
        @DisplayName("플레이어 수가 1명인 경우, 예외가 발생한다")
        void validateOnePlayer() {
            final List<String> onePlayerName = List.of("pobi");

            assertThatThrownBy(() -> new Players(onePlayerName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("플레이어 수가 0명인 경우, 예외가 발생한다")
        void validateZeroPlayer() {
            final List<String> zeroPlayerName = Collections.emptyList();

            assertThatThrownBy(() -> new Players(zeroPlayerName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("플레이어 수가 10명 초과인 경우, 예외가 발생한다")
        void validateOverTenPlayers() {
            final List<String> overTenPlayersName = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

            assertThatThrownBy(() -> new Players(overTenPlayersName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("플레이어의 이름이 중복되는 경우, 예외가 발생한다")
        void validateDuplicatedName() {
            final List<String> duplicatedPlayers = List.of("pobi", "pobi", "crong");

            assertThatThrownBy(() -> new Players(duplicatedPlayers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("모든 조건을 충족한 경우 Players 객체가 생성된다.")
        void playersInitiatorTest() {

            assertDoesNotThrow(() -> new Players(correctPlayerNames));
        }

    }


}
