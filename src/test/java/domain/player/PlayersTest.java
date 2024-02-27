package domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayersTest {
    @Test
    void 각_플레이어는_입력된_순서에_맞는_position을_가진다() {
        Players players = new Players(List.of(
                new Name("ddang"),
                new Name("bong"),
                new Name("bang")));

        int size = players.getPlayerCount();
        for (int i = 0; i < size; i++) {
            Assertions.assertEquals(i, players.findPlayerByIndex(i).getPosition());
        }
    }

    @Test
    void 범위를_벗어난_인덱스가_입력되면_예외가_발생한다() {
        Players players = new Players(List.of(
                new Name("name1"),
                new Name("name2")
        ));

        int outOfBoundIndex = 3;
        assertThatThrownBy(() -> players.findPlayerByIndex(outOfBoundIndex))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
