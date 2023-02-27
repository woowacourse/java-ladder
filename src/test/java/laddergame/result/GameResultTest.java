package laddergame.result;

import laddergame.ladder.Ladder;
import laddergame.ladder.LadderTest;
import laddergame.player.Players;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class GameResultTest {
    @Nested
    class 게임결과반환기능 {
        @Test
        void test_fetchAllResults_should_전체플레이어_게임결과_반환_when_fetchAllResults호출() {
            // given
            Players players = Players.from(List.of("00", "01", "02", "03", "04"));
            Ladder ladder = new Ladder(LadderTest.generateRowList());
            Prizes prizes = Prizes.from(List.of(
                    "0",
                    "1",
                    "2",
                    "3",
                    "4"
            ), 5);
            GameResult gameResult = GameResult.of(players.climbDownLadder(ladder), prizes);

            // when
            Map<String, String> gameResults = gameResult.fetchAllResults();

            //then
            assertThat(gameResults).contains(
                    entry("00", "2"),
                    entry("01", "0"),
                    entry("02", "1"),
                    entry("03", "3"),
                    entry("04", "4")
            );
        }

        @ParameterizedTest
        @CsvSource({"00,2", "01,0", "02,1", "03,3", "04,4"})
        void test_fetchResultByName_should_특정플레이어_게임결과_반환_when_fetchResultByName을호출하면(String name, String expected) {
            // given
            Players players = Players.from(List.of("00", "01", "02", "03", "04"));
            Ladder ladder = new Ladder(LadderTest.generateRowList());
            Prizes prizes = Prizes.from(List.of(
                    "0",
                    "1",
                    "2",
                    "3",
                    "4"
            ), 5);
            GameResult gameResult = GameResult.of(players.climbDownLadder(ladder), prizes);

            // when
            String actual = gameResult.fetchResultByName(name);

            //then
            assertThat(actual).isEqualTo(expected);
        }
    }
}
