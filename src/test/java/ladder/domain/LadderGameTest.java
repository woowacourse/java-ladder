package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderGameTest {

    private Users DEFAULT_USERS;
    private Ladder DEFAULT_LADDER;
    private Reward DEFAULT_REWARD;

    private final LineSource I_____I = LineSource.MAKE_LINE;
    private final LineSource IxxxxxI = LineSource.MAKE_BLANK;

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

    @Test
    @DisplayName("직선 사디레에서 전체 유저들의 보상을 테스트한다.")
    void getRewardOfAllUserTest1() {
        final LadderGame ladderGame = new LadderGame(DEFAULT_LADDER, DEFAULT_USERS, DEFAULT_REWARD);
        assertAll(() -> {
                    assertThat(ladderGame.getRewardOf("a")).isEqualTo("1");
                },
                () -> {
                    assertThat(ladderGame.getRewardOf("b")).isEqualTo("2");
                },
                () -> {
                    assertThat(ladderGame.getRewardOf("c")).isEqualTo("3");
                }
        );
    }

    @Test
    @DisplayName("전체 유저들의 보상을 테스트한다.")
    void getRewardOfAllUserTest2() {
        final Ladder ladder = new Ladder(3, DEFAULT_USERS);
        ladder.makeFloors(new TestLineSourceGenerator(List.of(
                I_____I, IxxxxxI,
                IxxxxxI, I_____I,
                IxxxxxI, IxxxxxI
        )));

        final LadderGame ladderGame = new LadderGame(ladder, DEFAULT_USERS, DEFAULT_REWARD);
        assertAll(() -> {
            assertThat(ladderGame.getRewardOf("a")).isEqualTo("3");
                },
                () -> {
            assertThat(ladderGame.getRewardOf("b")).isEqualTo("1");
                },
                () -> {
            assertThat(ladderGame.getRewardOf("c")).isEqualTo("2");
                }
        );
    }
}
