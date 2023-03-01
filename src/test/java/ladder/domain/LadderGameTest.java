package ladder.domain;

import ladder.dto.BridgeGameResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderGameTest {

    private final LineSource I_____I = LineSource.MAKE_LINE;
    private final LineSource IxxxxxI = LineSource.MAKE_BLANK;
    private static Users DEFAULT_USERS;
    private static Ladder DEFAULT_LADDER;
    private static Reward DEFAULT_REWARD;
    private static LadderGame DEFAULT_LADDER_GAME;

    @BeforeEach
    void setting() {
        DEFAULT_USERS = new Users(List.of("a", "b", "c"));
        DEFAULT_LADDER = new Ladder(3, 3);
        DEFAULT_REWARD = new Reward(List.of("1", "2", "3"));
        DEFAULT_LADDER_GAME = new LadderGame(DEFAULT_LADDER, DEFAULT_USERS, DEFAULT_REWARD);
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
    @DisplayName("직선 사다리에서 전체 유저들의 보상을 테스트한다.")
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
        final Ladder ladder = new Ladder(3, 3);
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

    @Test
    @DisplayName("사다리 게임에게 게임 결과를 반환하게하면 사다리 게임의 전체 결과를 반환한다.")
    void getRewardOfAllTest() {
        assertThat(DEFAULT_LADDER_GAME.getGameResult())
                .isInstanceOf(BridgeGameResult.class);
    }

    @Test
    @DisplayName("사다리 게임 결과 반환 값 테스트")
    void getRewardOfAllValueTest() {

        final BridgeGameResult gameResult = DEFAULT_LADDER_GAME.getGameResult();
        final Map<User, String> userAndReward = gameResult.getUserAndReward();
        final Set<User> users = userAndReward.keySet();

        final User a = getUserIn(users, "a");
        final User b = getUserIn(users, "b");
        final User c = getUserIn(users, "c");

        assertAll(
                () -> {
                    assertThat(userAndReward.get(a)).isEqualTo("1");
                },
                () -> {
                    assertThat(userAndReward.get(b)).isEqualTo("2");
                },
                () -> {
                    assertThat(userAndReward.get(c)).isEqualTo("3");
                }
        );
    }

    @Test
    @DisplayName("다리가 이어진 사다리 게임 결과 반환 값 테스트")
    void getRewardOfAllValueTest2() {
        final Ladder ladder = new Ladder(3, 3);
        ladder.makeFloors(new TestLineSourceGenerator(List.of(
                I_____I, IxxxxxI,
                IxxxxxI, I_____I,
                IxxxxxI, IxxxxxI
        )));
        final LadderGame ladderGame = new LadderGame(ladder, DEFAULT_USERS, DEFAULT_REWARD);

        final BridgeGameResult gameResult = ladderGame.getGameResult();
        final Map<User, String> userAndReward = gameResult.getUserAndReward();
        final Set<User> users = userAndReward.keySet();

        final User a = getUserIn(users, "a");
        final User b = getUserIn(users, "b");
        final User c = getUserIn(users, "c");

        assertAll(
                () -> {
                    assertThat(userAndReward.get(a)).isEqualTo("3");
                },
                () -> {
                    assertThat(userAndReward.get(b)).isEqualTo("1");
                },
                () -> {
                    assertThat(userAndReward.get(c)).isEqualTo("2");
                }
        );
    }

    @Test
    @DisplayName("사다리의 가로크기, 유저 수, 보상 수는 모두 같아야 하며 다를 시 예외가 발생한다")
    void LadderGameLengthExceptionTest() {
        assertThatThrownBy(() -> {
            new LadderGame(DEFAULT_LADDER, DEFAULT_USERS, new Reward(List.of("a", "b")));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리, 보상, 유저 수의 크기는 같아야 합니다.");

        assertThatThrownBy(() -> {
            new LadderGame(DEFAULT_LADDER, new Users(List.of("a", "b")), DEFAULT_REWARD);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리, 보상, 유저 수의 크기는 같아야 합니다.");

        assertThatThrownBy(() -> {
            new LadderGame(new Ladder(3, 2), DEFAULT_USERS, DEFAULT_REWARD);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리, 보상, 유저 수의 크기는 같아야 합니다.");

    }

    @Test
    @DisplayName("LadderGame의 getGameResultDto 값 존재 테스트 ")
    void getGameResultDtoTest() {
        final BridgeGameResultDto gameResultDto = DEFAULT_LADDER_GAME.getGameResultDto();
        final Map<String, String> userAndReward = gameResultDto.getUserAndReward();

        final Set<String> strings = userAndReward.keySet();
        final Collection<String> values = userAndReward.values();

        assertThat(strings).containsExactly("a", "b", "c");
        assertThat(values).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("LadderGame의 getGameResultDto 값 검증 테스트 ")
    void getGameResultDtoValueTest() {
        final BridgeGameResultDto gameResultDto = DEFAULT_LADDER_GAME.getGameResultDto();
        final Map<String, String> userAndReward = gameResultDto.getUserAndReward();

        assertAll(
                () -> {
                    assertThat(userAndReward.get("a")).isEqualTo("1");
                },
                () -> {
                    assertThat(userAndReward.get("b")).isEqualTo("2");
                },
                () -> {
                    assertThat(userAndReward.get("c")).isEqualTo("3");
                }
        );

    }

    private User getUserIn(final Set<User> users, final String name) {
        return users.stream()
                .filter(user -> user.isNameOf(name))
                .findFirst()
                .get();
    }
}
