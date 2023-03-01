package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import helper.StubTestDigitsGenerator;

public class LadderGameTest {
    private static LadderGame ladderGame;
    private static Players players;
    private static Ladder ladder;
    private static Prizes prizes;

    @BeforeAll
    static void set() {
        players = new Players(List.of("a", "b", "c", "d"));
        StubTestDigitsGenerator randomDigitsGenerator = new StubTestDigitsGenerator(
                List.of(1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0)
        );
        ladder = new Ladder(4, players.getCount() - 1, randomDigitsGenerator);
        ladderGame = new LadderGame(players, ladder);
        prizes = new Prizes(
                List.of("야근하기", "5000원", "퇴근하기", "꽝"), players);
    }

    @DisplayName("플레이어의 이름을 통해 사다리 최종 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"a,야근하기", "b,퇴근하기", "c,꽝", "d,5000원"})
    void get_result_of_player(String name, String expected) {
        List<String> result = ladderGame.getResult(name, prizes);

        assertThat(result).isEqualTo(List.of(expected));
    }

    @DisplayName("all 인경우 모든 플레이어들의 사다리 최종 결과를 반환한다.")
    @Test
    void get_result_of_All() {
        List<String> result = ladderGame.getResult("all", prizes);

        assertThat(result).isEqualTo(List.of("야근하기", "퇴근하기", "꽝", "5000원"));
    }

}

