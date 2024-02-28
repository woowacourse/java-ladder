package ladder.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import ladder.domain.resource.ladder.Ladder;
import ladder.domain.resource.ladder.LadderGenerator;
import ladder.domain.resource.line.CustomLineGenerator;
import ladder.domain.resource.prize.Prize;
import ladder.domain.resource.prize.Prizes;
import ladder.domain.resource.user.User;
import ladder.domain.resource.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameExecutorTest {

    GameResource gameResource;
    GameExecutor gameExecutor;
    GameResult gameResult;

    @BeforeEach
    void beforeEach() {
        gameResource = new GameResource();
        gameExecutor = new GameExecutor();
        gameResult = new GameResult();
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

    @DisplayName("게임을 실행하면 모든 사용자의 게임 결과가 저장된다.")
    @Test
    void execute() {
        //given
        Users users = ResourceGenerator.generateUsersWithCount(2);
        User userA = users.getUserByIndex(0);
        User userB = users.getUserByIndex(1);

        gameResource.addUsers(users);
        gameResource.addLadder(ResourceGenerator.generateLadderWithWidth(2));
        gameResource.addPrizes(ResourceGenerator.generatePrizesWithCount(2));

        //when
        gameExecutor.execute(gameResource, gameResult);
        HashMap<User, Prize> result = gameResult.getAllResult();

        //then
        assertThat(result).hasSize(2).containsKeys(userA, userB);
    }

    @DisplayName("게임을 실행하면 사다리 방향에 맞게 사다리를 이동하여 당첨품이 결정된다.")
    @Test
    void confirmResult() {
        //given
        LadderGenerator ladderGenerator = new LadderGenerator(new CustomLineGenerator());
        Ladder ladder = ladderGenerator.generate(3, 3);

        Users users = ResourceGenerator.generateUsersWithCount(3);
        User userA = users.getUserByIndex(0);
        User userB = users.getUserByIndex(1);
        User userC = users.getUserByIndex(2);

        Prizes prizes = ResourceGenerator.generatePrizesWithCount(3);
        Prize prizeA = prizes.getPrizeByIndex(0);
        Prize prizeB = prizes.getPrizeByIndex(1);
        Prize prizeC = prizes.getPrizeByIndex(2);

        gameResource.addUsers(users);
        gameResource.addLadder(ladder);
        gameResource.addPrizes(prizes);

        //when
        gameExecutor.execute(gameResource, gameResult);
        HashMap<User, Prize> result = gameResult.getAllResult();

        //then
        assertThat(result).hasSize(3)
                .containsEntry(userA, prizeB)
                .containsEntry(userB, prizeA)
                .containsEntry(userC, prizeC);
    }
}
