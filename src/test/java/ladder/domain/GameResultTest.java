package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

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

        Player player = players.findBy("a");
        Map<Player, Item> result = gameResult.findResult(player);

        assertThat(result).containsEntry(player, items.findBy(0));
    }

    @Test
    @DisplayName("플레이어 전체의 결과를 반환")
    void shouldReturnAllPlayerResultsWhenRequest() {
        Players players = Players.generate(List.of("a", "b"));
        Items items = Items.generate(List.of("1", "2"), players.getSize());
        GameResult gameResult = GameResult.of(players, items);

        Map<Player, Item> result = gameResult.findAll();

        assertThat(result).containsExactly(
                entry(players.findBy("a"), items.findBy(0)),
                entry(players.findBy("b"), items.findBy(1))
        );
    }
}
