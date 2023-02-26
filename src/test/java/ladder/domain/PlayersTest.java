package ladder.domain;

import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayersTest {

    private static final List<String> correctPlayerNames = List.of("pobi", "crong", "honux");
    private static final List<String> rewardNames = List.of("꽝", "성공", "실패");
    private static Players correctPlayers;

    @BeforeAll
    static void setup() {
        correctPlayers = Players.from(correctPlayerNames);
    }

    @Test
    @DisplayName("플레이어의 수 반환 테스트")
    void findNumberOfAllPlayersTest() {

        assertThat(correctPlayers.findNumberOfAllPlayers())
                .isEqualTo(correctPlayerNames.size());
    }

    @Test
    @DisplayName("플레이어 이름 리스트 반환 테스트")
    void getNameTest() {

        assertThat(correctPlayers.findNameOfAllPlayers())
                .isEqualTo(correctPlayerNames);
    }

    @Nested
    @DisplayName("Players 객체를 생성할 때, ")
    class PlayersInitiator {

        @Test
        @DisplayName("플레이어 수가 1명인 경우, 예외가 발생한다")
        void validateOnePlayer() {
            List<String> onePlayerName = List.of("pobi");

            assertThatThrownBy(() -> Players.from(onePlayerName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("플레이어 수가 0명인 경우, 예외가 발생한다")
        void validateZeroPlayer() {
            List<String> zeroPlayerName = Collections.emptyList();

            assertThatThrownBy(() -> Players.from(zeroPlayerName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("플레이어 수가 10명 초과인 경우, 예외가 발생한다")
        void validateOverTenPlayers() {
            List<String> overTenPlayersName = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

            assertThatThrownBy(() -> Players.from(overTenPlayersName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("플레이어의 이름이 중복되는 경우, 예외가 발생한다")
        void validateDuplicatedName() {
            List<String> duplicatedPlayers = List.of("pobi", "pobi", "crong");

            assertThatThrownBy(() -> Players.from(duplicatedPlayers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("모든 조건을 충족한 경우 Players 객체가 생성된다.")
        void playersInitiatorTest() {

            assertDoesNotThrow(() -> Players.from(correctPlayerNames));
        }

    }

    @Nested
    @DisplayName("각 플레이어와 보상을 제대로 연결지었는지 테스트")
    class RewardOfPlayersTest {

        @BeforeEach
        void setup() {
            IntStream.range(0, correctPlayerNames.size())
                    .forEach(i -> correctPlayers.rewardPlayer(i, new Reward(rewardNames.get(i))));
        }

        @ParameterizedTest
        @CsvSource(value = {"pobi,꽝", "crong,성공", "honux,실패"})
        @DisplayName("플레이어에 해당하는 보상을 제대로 연결짓는지 확인한다.")
        void rewardPlayerTest(String player, String reward) {
            Map<String, String> result = correctPlayers.findRewardOfPlayerBy(player);

            assertThat(result.get(player))
                    .isEqualTo(reward);
        }

        @ParameterizedTest
        @CsvSource(value = {"pobi,꽝", "crong,성공", "honux,실패"})
        @DisplayName("모든 플레이어에 해당하는 보상을 제대로 연결짓는지 확인한다.")
        void rewardAllPlayerTest(String player, String reward) {
            Map<String, String> result = correctPlayers.findRewardsOfPlayers();

            assertThat(result.get(player))
                    .isEqualTo(reward);
        }
    }
}
