package domain;

import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void 사용자_생성() {
        final Name name = new Name("깃짱");
        final Position initialPosition = new Position(0);
        final Player gitJjang = new Player(name, initialPosition);

        Assertions.assertEquals(gitJjang.getName(), name);
        Assertions.assertEquals(gitJjang.getPosition(), initialPosition);
    }
}
