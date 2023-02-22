package domain;

import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {
    private final Name name = new Name("깃짱");
    private final Position initialPosition = new Position(0);
    private final Player gitJjang = new Player(name, initialPosition);

    @Test
    void 사용자_생성() {
        Assertions.assertEquals(gitJjang.getName(), name);
        Assertions.assertEquals(gitJjang.getPosition(), initialPosition);
    }
}
