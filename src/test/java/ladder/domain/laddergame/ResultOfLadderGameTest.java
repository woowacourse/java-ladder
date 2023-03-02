package ladder.domain.laddergame;

import ladder.domain.MockRandomBooleanGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultOfLadderGameTest {

    private static final int heightOfLadder = 3;
    private static final List<String> playerNames = List.of("pobi", "crong", "honux");
    private static final List<String> rewardNames = List.of("꽝", "1000원", "2000원");
    private static ResultOfLadderGame result;

    @BeforeAll
    static void setup() {
        final Players players = new Players(playerNames);
        final Ladder ladder = new Ladder(heightOfLadder, players.findNumberOfPlayers(), new MockRandomBooleanGenerator());
        final Rewards rewards = new Rewards(players.findNumberOfPlayers(), rewardNames);

        players.movePlayers(ladder);

        result = new ResultOfLadderGame(players.findResultOfPlayersWith(rewards));
    }

    @Nested
    @DisplayName("Result가 생성된 후, 결과의 요청값(request)이")
    class findValidRequestTest {

        /**
         * t,f
         * t,f
         * t,f
         */


        @Test
        @DisplayName("all 이나 PlayerNames에 있는 이름이 아닐 때, 예외가 발생한다")
        void findValidRequestWhenInputErrorTest() {
            final String invalidRequest = "ire";
            assertThatThrownBy(() -> result.findValidRequest(invalidRequest))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("해당하는 플레이어의 이름이 없습니다.");
        }

        @ParameterizedTest
        @CsvSource(value = {"all,all", "pobi,pobi", "crong,crong", "honux,honux"})
        @DisplayName("all 이나 PlayerNames에 있는 이름이면, 해당 request를 반환한다")
        void findValidRequestWhenInputVaildTest(final String input, final String validRequest) {
            assertThat(result.findValidRequest(input))
                    .isEqualTo(validRequest);
        }

    }

    @Nested
    @DisplayName("Result가 생성된 후, 결과의 요청값(request)이")
    class findResultByRequestTest {

        /**
         * t,f
         * t,f
         * t,f
         */
        @Test
        @DisplayName("all일 때, 모든 플레이어의 매칭 결과를 반환한다")
        void getResultOfAllTest() {

            final Map<String, String> resultOfAll = result.findResultByRequest("all");

            assertThat(resultOfAll.get("pobi")).isEqualTo("1000원");
            assertThat(resultOfAll.get("crong")).isEqualTo("꽝");
            assertThat(resultOfAll.get("honux")).isEqualTo("2000원");
        }

        @ParameterizedTest
        @CsvSource(value = {"pobi,1000원", "crong,꽝", "honux,2000원"})
        @DisplayName("플레이어일 때, 해당 플레이어의 매칭 결과를 반환한다")
        void getResultByNameTest(final String name, final String reward) {
            final Map<String, String> resultOfOnePlayer = result.findResultByRequest(name);

            assertThat(resultOfOnePlayer.get(name)).isEqualTo(reward);
        }
    }

}
