package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    @DisplayName("플레이어의 position과 같은 item을 반환")
    void shouldSamePositionPlayerAndItemWhenInput() {
        Players players = Players.generate(List.of("a", "b"));
        Items items = Items.generate(List.of("1", "2"), players.getSize());
        GameResult gameResult = GameResult.of(players, items);

        Map<String, String> result = gameResult.findResult(new Name("a"));

        assertThat(result).containsEntry("a", "1");
    }

    @Test
    @DisplayName("플레이어 전체의 결과를 반환")
    void shouldReturnAllPlayerResultsWhenRequest() {
        Players players = Players.generate(List.of("a", "b"));
        Items items = Items.generate(List.of("1", "2"), players.getSize());
        GameResult gameResult = GameResult.of(players, items);

        Map<String, String> result = gameResult.findAll();

        assertAll(
                () -> assertThat(result).containsEntry("a", "1"),
                () -> assertThat(result).containsEntry("b", "2"));
    }

}
