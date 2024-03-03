package domain;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.stick.Stick;
import domain.ladder.stick.StickGenerator;
import domain.ladder.sticks.SticksGenerator;
import domain.player.Player;
import domain.player.Players;
import domain.result.Result;
import domain.result.Results;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGameRecordTest {

    private LadderGameRecord ladderGameRecord;

    @BeforeEach
    void setUp() {
        int height = 2;
        Players players = new Players(List.of("산초", "아톰"));
        Ladder ladder = Ladder.of(new Height(height), players.getPlayerSize(), mockSticksGenerator());
        Results results = new Results(List.of("꽝", "당첨"), players.getPlayerSize());
        ladderGameRecord = new LadderGameRecord(players, ladder, results);
    }

    private StickGenerator mockStickGenerator() {
        return () -> Stick.FILLED;
    }

    private SticksGenerator mockSticksGenerator() {
        return (mockStickGenerator) -> List.of(Stick.FILLED, Stick.NOT_FILLED);
    }

    @DisplayName("사다리 타기 실행 결과를 반환한다.")
    @Nested
    class resultTest {
        @DisplayName("전체 사용자의 사다리 타기 결과를 반환한다.")
        @Test
        void checkAllResult() {
            Map<Player, Result> playerResult = ladderGameRecord.getAllPlayerResults();

            assertAll(
                    () -> assertThat(playerResult).containsEntry(new Player("산초"), new Result("꽝")),
                    () -> assertThat(playerResult).containsEntry(new Player("아톰"), new Result("당첨"))
            );
        }

        @DisplayName("한 사용자의 사다리 타기 결과를 반환한다.")
        @ParameterizedTest
        @CsvSource(value = {"산초:꽝", "아톰:당첨"}, delimiter = ':')
        void checkOneResult(String playerName, String resultValue) {
            Result result = ladderGameRecord.getOnePlayerResult(playerName);

            assertThat(result).isEqualTo(new Result(resultValue));
        }
    }
}
