package domain.player;

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
}
