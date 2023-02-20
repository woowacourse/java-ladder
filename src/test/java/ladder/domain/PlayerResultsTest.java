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
        PlayerResults playerResults = new PlayerResults(createPlayers(), createResults());

        // when
        Result result = playerResults.getResultByPlayer(new Player("glen"));

        // then
        assertThat(result.getResult())
                .isEqualTo("5000");
    }

    private List<Player> createPlayers() {
        return List.of(
                new Player("glen"),
                new Player("doggy"),
                new Player("pobi")
        );
    }

    private List<Result> createResults() {
        return List.of(
                new Result("5000"),
                new Result("꽝"),
                new Result("3000")
        );
    }
}
