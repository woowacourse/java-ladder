package domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.player.Name;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultsTest {
    @Test
    void Results는_인덱스에_해당하는_Result를_반환한다() {
        Results results = new Results(List.of(
                new Result("꽝1"),
                new Result("꽝2"),
                new Result("꽝3")));

        Result foundResult = results.findResultByIndex(1);
        assertEquals("꽝2", foundResult.getValue());
    }

    @Test
    void 각_플레이어의_현재_위치에_대한_결과를_출력할_수_있다() {
        // given
        Players players = new Players(List.of(
                new Name("name1"),
                new Name("name2")
        ));

        Results results = new Results(List.of(
                new Result("꽝1"),
                new Result("꽝2")));

        final Result result1 = results.findResultByPlayer(players.findPlayerByIndex(0));
        final Result result2 = results.findResultByPlayer(players.findPlayerByIndex(1));

        assertThat(result1.getValue()).isEqualTo("꽝1");
        assertThat(result2.getValue()).isEqualTo("꽝2");
    }
}
