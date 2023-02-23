package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerResultsTest {

    @Test
    @DisplayName("게임의 결과가 제대로 생성되어야 한다.")
    void create_success() {
        // given
        PlayerResults playerResults = new PlayerResults(createPlayerResults());

        // when
        PlayerResult result = playerResults.findByPlayer(new Player("glen"));

        // then
        assertThat(result.getPrize())
                .isEqualTo("1000");
    }

    private static List<PlayerResult> createPlayerResults() {
        return List.of(
                new PlayerResult(
                        new Player("glen"),
                        new Prize("1000")
                ),
                new PlayerResult(
                        new Player("doggy"),
                        new Prize("5000")
                ),
                new PlayerResult(
                        new Player("pobi"),
                        new Prize("꽝")
                )
        );
    }
}
