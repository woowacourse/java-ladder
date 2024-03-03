package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import ladder.domain.game.GameExecutor;
import ladder.domain.ladder.Ladder;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    GameResource gameResource = new GameResource();
    GameExecutor gameExecutor = new GameExecutor();
    GameResult gameResult = new GameResult();

    @DisplayName("게임에 사용될 자원을 등록한다.")
    @Test
    void registerResource() {
        //given
        Users users = ResourceGenerator.generateUsersWithCount(2);
        Prizes prizes = ResourceGenerator.generatePrizesWithCount(2);
        Ladder ladder = ResourceGenerator.generateLadderWithWidth(2);

        LadderGame ladderGame = new LadderGame(gameResource, gameExecutor, gameResult);

        //when
        ladderGame.registerResource(users, prizes, ladder);

        Users savedUsers = gameResource.getUsers();
        Prizes savedPrizes = gameResource.getPrizes();
        Ladder savedLadder = gameResource.getLadder();

        //then
        assertThat(savedUsers).isEqualTo(users);
        assertThat(savedPrizes).isEqualTo(prizes);
        assertThat(savedLadder).isEqualTo(ladder);
    }

    @DisplayName("게임을 시작하고 결과를 반환한다.")
    @Test
    void startGame() {
        //given
        int numberOfResource = 2;
        Users users = ResourceGenerator.generateUsersWithCount(numberOfResource);
        Prizes prizes = ResourceGenerator.generatePrizesWithCount(numberOfResource);
        Ladder ladder = ResourceGenerator.generateLadderWithWidth(numberOfResource);

        LadderGame ladderGame = new LadderGame(gameResource, gameExecutor, gameResult);
        ladderGame.registerResource(users, prizes, ladder);

        //when
        ladderGame.startGame();
        GameResult gameResult = ladderGame.getGameResult();
        HashMap<User, Prize> allResult = gameResult.getAllResult();

        //then
        assertThat(allResult).hasSize(numberOfResource);
    }

}
