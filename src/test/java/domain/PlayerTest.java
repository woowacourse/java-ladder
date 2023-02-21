package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {
    private Name name = new Name("깃짱");
    private Position initialPosition = new Position(0);
    private Player gitJjang = new Player(name, initialPosition);

    @Test
    void 사용자_생성() {
        Assertions.assertEquals(gitJjang.getName(), name);
        Assertions.assertEquals(gitJjang.getPosition(), initialPosition);
    }
}
