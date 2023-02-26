package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LadderGameTest {

    private static final List<String> playerNames = List.of("pobi", "crong", "honux");
    private static final List<String> rewardNames = List.of("꽝", "1000원", "2000원");
    private LadderGame ladderGame;

    @BeforeEach
    void setup() {
        Players players = Players.from(playerNames);
        Ladder ladder = Ladder.of(players.findNumberOfAllPlayers(), 3, new MockRandomBarGenerator());
        Rewards rewards = new Rewards(players.findNumberOfAllPlayers(), rewardNames);

        ladderGame = new LadderGame(players, ladder, rewards);
    }

    @Test
    @DisplayName("사다리 게임 내에 플레이어 이름이 예상대로 생성되었는지 확인한다")
    void findPlayerNamesTest() {
        assertThat(ladderGame.findPlayerNames())
                .isEqualTo(playerNames);
    }

    @Nested
    @DisplayName("LadderGame이 생성된 후, 결과의 요청값(request)이")
    class tracePathTest {

        /**
         * t,f
         * t,f
         * t,f
         */

        @Test
        @DisplayName("all 이나 PlayerNames에 있는 이름이 아닐 때, 예외가 발생한다")
        void findValidRequestErrorTest() {
            String invalidRequest = "ire";
            assertThatThrownBy(() -> ladderGame.findValidRequest(invalidRequest))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("해당하는 플레이어의 이름이 없습니다.");
        }

        @ParameterizedTest
        @CsvSource(value = {"all,all", "pobi,pobi", "crong,crong", "honux,honux"})
        @DisplayName("all 이나 PlayerNames에 있는 이름이면, 해당 request를 반환한다")
        void findValidRequestTest(String input, String validRequest) {
            assertThat(ladderGame.findValidRequest(input))
                    .isEqualTo(validRequest);
        }

        @Test
        @DisplayName("all일 때, 모든 플레이어의 매칭 결과를 반환한다")
        void getResultOfAllTest() {

            Map<String, String> resultOfAll = ladderGame.findRewardsOfPlayersByRequest("all");

            assertThat(resultOfAll.get("pobi")).isEqualTo("1000원");
            assertThat(resultOfAll.get("crong")).isEqualTo("꽝");
            assertThat(resultOfAll.get("honux")).isEqualTo("2000원");
        }

        @ParameterizedTest
        @CsvSource(value = {"pobi,1000원", "crong,꽝", "honux,2000원"})
        @DisplayName("플레이어일 때, 해당 플레이어의 매칭 결과를 반환한다")
        void getResultByNameTest(String name, String result) {
            Map<String, String> resultOfOnePlayer = ladderGame.findRewardsOfPlayersByRequest(name);

            assertThat(resultOfOnePlayer.get(name)).isEqualTo(result);
        }

    }

}
