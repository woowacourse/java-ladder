package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    void 높이_유효성_테스트() {
        int countOfPlayers = 5;
        int height = 0;
        assertThrows(IllegalArgumentException.class, ()->{
            new Ladder(height, countOfPlayers);
        });
    }

    @Test
    void 사람_수_테스트() {
        int countOfPlayers = 0;
        int height = 5;
        assertThrows(IllegalArgumentException.class, ()->{
            new Ladder(height, countOfPlayers);
        });
    }
}
