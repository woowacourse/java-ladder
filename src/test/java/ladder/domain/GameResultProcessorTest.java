package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class GameResultProcessorTest {
    @Test
    void should_전체플레이어_게임결과_반환_when_fetchAllResults호출() {
        // given
        Players players = Players.from(List.of("00", "01", "02", "03", "04"));
        Ladder ladder = new Ladder(LadderTest.generateRowList());
        Prizes prizes = Prizes.from(List.of(
                "0",
                "1",
                "2",
                "3",
                "4"
        ));
        GameResultProcessor gameResultProcessor = GameResultProcessor.process(players.climbDownLadder(ladder), prizes);

        // when
        Map<String, String> gameResults = gameResultProcessor.fetchAllResults();

        //then
        assertThat(gameResults).contains(
                entry("00", "2"),
                entry("01", "0"),
                entry("02", "1"),
                entry("03", "3"),
                entry("04", "4")
        );
    }

    @Test
    void should__when_() {
        // given

        // when

        //then
    }
}