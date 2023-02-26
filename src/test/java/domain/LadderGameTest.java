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

    @BeforeAll
    static void set() {
        players = new Players(List.of("a", "b", "c", "d"));
        StubTestDigitsGenerator randomDigitsGenerator = new StubTestDigitsGenerator(
                List.of(1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0)
        );
        ladder = new Ladder(4, players.getCount() - 1, randomDigitsGenerator);
        ladderGame = new LadderGame(players, ladder);
    }

    @DisplayName("플레이어의 이름을 통해 사다리 최종 위치를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"a,0", "b,2", "c,3", "d,1"})
    void get_result_of_player(String name, int expected) {
        List<Integer> result = ladderGame.getResult(name);

        assertThat(result).isEqualTo(List.of(expected));
    }

    @DisplayName("all 인경우 모든 플레이어들의 사다리 최종 위치를 반환한다.")
    @Test
    void get_result_of_All() {
        List<Integer> result = ladderGame.getResult("all");

        assertThat(result).isEqualTo(List.of(0, 2, 3, 1));
    }

}

