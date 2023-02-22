package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderGameTest {

    private Users DEFAULT_USERS;
    private Ladder DEFAULT_LADDER;
    private Reward DEFAULT_REWARD;

    @BeforeEach
    void setting() {
        DEFAULT_USERS = new Users(List.of("a", "b", "c"));
        DEFAULT_LADDER = new Ladder(3, DEFAULT_USERS);
        DEFAULT_REWARD = new Reward(List.of("1", "2", "3"));
    }

    @Test
    @DisplayName("사다리 게임은 사다리와 유저들로 이루어진 게임이다.")
    void validLadderGameTest() {
        assertDoesNotThrow(() -> new LadderGame(DEFAULT_LADDER, DEFAULT_USERS, DEFAULT_REWARD));
    }

    @Test
    @DisplayName("사다리 게임에 유저의 이름을 입력하면 해당 유저의 보상을 알려준다.")
    void getRewardOfUserByBridgeGameTest() {
        final LadderGame ladderGame = new LadderGame(DEFAULT_LADDER, DEFAULT_USERS, DEFAULT_REWARD);
        assertThat(ladderGame.getRewardOf("a")).isEqualTo("1");
    }
}
