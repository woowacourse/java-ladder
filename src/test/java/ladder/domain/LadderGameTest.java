package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class LadderGameTest {

    private List<String> playerNames = List.of("pobi", "crong", "honux");
    private Players players = Players.from(playerNames);
    private Ladder ladder = Ladder.of(players.findNumberOfPlayers(), 3, new MockRandomDataGenerator());
    private Rewards rewards = new Rewards(players.findNumberOfPlayers(), List.of("꽝", "1000원", "2000원"));
    private LadderGame ladderGame = new LadderGame(players, ladder, rewards);

    @Nested
    @DisplayName("LadderGame이 start되고")
    class tracePathTest {
        @BeforeEach
        void setup() {
            ladderGame.trace();
        }

        /**
         * t,f
         * t,f
         * t,f
         */
        @Test
        @DisplayName("예상한 값과 일치한 매칭 결과를 반환한다")
        void getResultOfAllTest() {

            Map<String, String> resultOfAll = ladderGame.showResult();

            assertThat(resultOfAll.get("pobi")).isEqualTo("1000원");
            assertThat(resultOfAll.get("crong")).isEqualTo("꽝");
            assertThat(resultOfAll.get("honux")).isEqualTo("2000원");
        }

//        @ParameterizedTest
//        @CsvSource(value = {"pobi,꽝", "crong,2000원", "honux,3000원"})
//        @DisplayName("명령어가 이름일 때, 예상한 값과 일치한 값을 반환한다")
//        void getResultByNameTest(String name, String result) {
//
//            assertThat(ladderGame.getResultBy(name)).isEqualTo(result);
//
//        }

    }

}
