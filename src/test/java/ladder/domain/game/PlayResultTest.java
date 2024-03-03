package ladder.domain.game;

import ladder.domain.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayResultTest {
    private PlayResult playResult;

    @BeforeEach
    void setUp() {
        playResult = new PlayResult();
    }

    @Test
    @DisplayName("참여자 이름에 해당하는 결과가 존재하는지 판별할 수 있다.")
    void findPlayerResultByName() {
        playResult.recordResult(List.of(new Player("pobi", 0)), List.of("5000"));

        String result = playResult.findPlayerResultByName("pobi");

        assertThat(result).isEqualTo("5000");
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi, 5000", "honux, 3000", "crong, 꽝", "jk, 꽝"})
    @DisplayName("참여자 이름에 해당하는 결과를 얻을 수 있다.")
    void checkPlayerResultByName(String name, String expected) {
        List<Player> players = List.of(
                new Player("pobi", 0), new Player("crong", 1),
                new Player("honux", 2), new Player("jk", 3));
        List<String> prizes = List.of("5000", "꽝", "3000", "꽝");
        playResult.recordResult(players, prizes);

        String actual = playResult.findPlayerResultByName(name);

        assertThat(actual).isEqualTo(expected);
    }
}
