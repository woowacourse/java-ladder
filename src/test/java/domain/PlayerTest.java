package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void 사용자_생성() {
        Name gitJjang = new Name("깃짱");
        Position initialPosition = new Position(0);
        Player player = new Player(gitJjang, initialPosition);

        Assertions.assertEquals(player.getName(), gitJjang);
        Assertions.assertEquals(player.getPosition(), initialPosition);
    }
}
