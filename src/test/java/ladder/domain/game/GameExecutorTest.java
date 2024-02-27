package ladder.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.domain.resource.ladder.Ladder;
import ladder.domain.resource.prize.Prizes;
import ladder.domain.resource.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameExecutorTest {

    GameResource gameResource;
    GameExecutor gameExecutor;

    @BeforeEach
    void beforeEach() {
        gameResource = new GameResource();
        gameExecutor = new GameExecutor();
    }

    @DisplayName("게임 환경 검증 시, 사용자가 없을 경우 예외를 발생시킨다.")
    @Test
    void gameEnvironmentCheckTestByNoUsers() {
        //given
        gameResource.addLadder(ResourceGenerator.generateLadderWithWidth(2));
        gameResource.addPrizes(ResourceGenerator.generatePrizesWithCount(2));

        //when, then
        assertThatThrownBy(() -> gameExecutor.validateGameEnvironment(gameResource))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자 정보가 없습니다.");
    }

    @DisplayName("게임 환경 검증 시, 사다리가 없을 경우 예외를 발생시킨다.")
    @Test
    void gameEnvironmentCheckTestByNoLadder() {
        //given
        gameResource.addUsers(ResourceGenerator.generateUsersWithCount(2));
        gameResource.addPrizes(ResourceGenerator.generatePrizesWithCount(2));

        //when, then
        assertThatThrownBy(() -> gameExecutor.validateGameEnvironment(gameResource))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리 정보가 없습니다.");
    }

    @DisplayName("게임 환경 검증 시, 당첨품이 없을 경우 예외를 발생시킨다.")
    @Test
    void gameEnvironmentCheckTestByNoPrizes() {
        //given
        gameResource.addUsers(ResourceGenerator.generateUsersWithCount(2));
        gameResource.addLadder(ResourceGenerator.generateLadderWithWidth(2));

        //when, then
        assertThatThrownBy(() -> gameExecutor.validateGameEnvironment(gameResource))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨품 정보가 없습니다.");
    }

    @DisplayName("게임 환경 검증 시, 모든 자원의 크기가 동일하지 않은 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource({
            "2, 2, 3",
            "2, 3, 2",
            "3, 2, 2"
    })
    void gameEnvironmentCheckTestByNotConsistentSize(int numberOfUsers, int ladderWidth, int numberOfPrizes) {
        //given
        Users users = ResourceGenerator.generateUsersWithCount(numberOfUsers);
        Ladder ladder = ResourceGenerator.generateLadderWithWidth(ladderWidth);
        Prizes prizes = ResourceGenerator.generatePrizesWithCount(numberOfPrizes);

        gameResource.addUsers(users);
        gameResource.addLadder(ladder);
        gameResource.addPrizes(prizes);

        //when, then
        assertThatThrownBy(() -> gameExecutor.validateGameEnvironment(gameResource))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자 수, 사다리 너비, 당첨품 수는 모두 일치해야 합니다.");
    }
}
