package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderGameTest {

    private Users DEFAULT_USERS;
    private Ladder DEFAULT_LADDER;

    @BeforeEach
    void setting() {
        DEFAULT_USERS = new Users(List.of("a", "b", "c"));
        DEFAULT_LADDER = new Ladder(3, DEFAULT_USERS);
    }

    @Test
    @DisplayName("사다리 게임은 사다리와 유저들로 이루어진 게임이다.")
    void validLadderGameTest() {
        assertDoesNotThrow(() -> new LadderGame(DEFAULT_LADDER, DEFAULT_USERS));
    }
}
