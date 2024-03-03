package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import ladder.domain.direction.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameTest {

    LadderGame ladderGame;

    @BeforeEach
    void beforeEach() {
        ladderGame = new LadderGame(new GameResource(), new GameResult());
    }

    @DisplayName("게임에 사용될 자원을 등록한다.")
    @Test
    void registerResource() {
        //given
        Users users = ResourceGenerator.generateUsers(2);
        Prizes prizes = ResourceGenerator.generatePrizes(2);
        Ladder ladder = ResourceGenerator.generateLadderWithHeightAndWidth(2, 2);

        //when
        ladderGame.registerResource(users, prizes, ladder);

        GameResource gameResource = ladderGame.getGameResource();
        Users savedUsers = gameResource.getUsers();
        Prizes savedPrizes = gameResource.getPrizes();
        Ladder savedLadder = gameResource.getLadder();

        //then
        assertThat(savedUsers).isEqualTo(users);
        assertThat(savedPrizes).isEqualTo(prizes);
        assertThat(savedLadder).isEqualTo(ladder);
    }

    @DisplayName("게임을 실행하면 모든 사용자의 게임 결과가 저장된다.")
    @Test
    void startGame() {
        //given
        int numberOfResource = 2;
        Users users = ResourceGenerator.generateUsers(numberOfResource);
        User userA = users.getUserByIndex(0);
        User userB = users.getUserByIndex(1);

        Prizes prizes = ResourceGenerator.generatePrizes(numberOfResource);
        Ladder ladder = ResourceGenerator.generateLadderWithHeightAndWidth(50, numberOfResource);

        ladderGame.registerResource(users, prizes, ladder);

        //when
        ladderGame.startGame();
        GameResult gameResult = ladderGame.getGameResult();
        Map<User, Prize> allResult = gameResult.getAllResult();

        //then
        assertThat(allResult).hasSize(numberOfResource).containsKeys(userA, userB);
    }

    @DisplayName("게임을 리소스를 등록하지 않고 게임을 실행할 경우 예외가 발생한다.")
    @Test
    void startGameByNotRegisterResource() {
        //given, when, then
        assertThatThrownBy(() -> ladderGame.startGame())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 리소스가 등록되지 않았습니다. 리소스를 먼저 등록해주세요.");
    }

    @DisplayName("게임을 리소스의 크기가 동일하지 않은 상태에서 게임을 실행할 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({
            "2, 2, 3",
            "2, 3, 2",
            "3, 2, 2"
    })
    void startGameByResourceDifferentSize(int numberOfUsers, int ladderWidth, int numberOfPrizes) {
        //given
        Users users = ResourceGenerator.generateUsers(numberOfUsers);
        Prizes prizes = ResourceGenerator.generatePrizes(ladderWidth);
        Ladder ladder = ResourceGenerator.generateLadderWithHeightAndWidth(2, numberOfPrizes);

        ladderGame.registerResource(users, prizes, ladder);

        // when, then
        assertThatThrownBy(() -> ladderGame.startGame())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자 수, 당첨품 수, 사다리 너비는 모두 일치해야 합니다.");
    }

    @DisplayName("게임을 실행하면 사다리 방향에 맞게 사다리를 이동하여 당첨품이 결정된다.")
    @Test
    void confirmResult() {
        //given
        Users users = ResourceGenerator.generateUsers(3);
        User userA = users.getUserByIndex(0);
        User userB = users.getUserByIndex(1);
        User userC = users.getUserByIndex(2);

        Prizes prizes = ResourceGenerator.generatePrizes(3);
        Prize prizeA = prizes.getPrizeByIndex(0);
        Prize prizeB = prizes.getPrizeByIndex(1);
        Prize prizeC = prizes.getPrizeByIndex(2);

        List<Direction> directions = List.of(
                Direction.RIGHT,
                Direction.LEFT,
                Direction.NEUTRAL
        );
        Ladder ladder = new Ladder(List.of(
                new Line(directions),
                new Line(directions),
                new Line(directions)
        ));

        ladderGame.registerResource(users, prizes, ladder);

        //when
        ladderGame.startGame();
        GameResult gameResult = ladderGame.getGameResult();
        Map<User, Prize> result = gameResult.getAllResult();

        //then
        assertThat(result).hasSize(3)
                .containsEntry(userA, prizeB)
                .containsEntry(userB, prizeA)
                .containsEntry(userC, prizeC);
    }
}
