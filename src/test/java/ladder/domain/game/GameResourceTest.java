package ladder.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.domain.resource.ladder.Ladder;
import ladder.domain.resource.prize.Prizes;
import ladder.domain.resource.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResourceTest {

    GameResource gameResource;

    @BeforeEach
    void beforeEach() {
        gameResource = new GameResource();
    }

    @DisplayName("게임 리소스에 사용자를 추가한다.")
    @Test
    void addUsersTest() {
        //given
        Users users = ResourceGenerator.generateUsersWithCount(2);
        gameResource.addUsers(users);

        //when
        Users savedUsers = gameResource.getUsers();

        //then
        assertThat(savedUsers).isEqualTo(users);
    }

    @DisplayName("게임 리소스에 사용자 추가 시, 값이 null일 경우 에외를 발생시킨다.")
    @Test
    void addUsersTestByNull() {
        //given
        Users nullUsers = null;

        //when, then
        assertThatThrownBy(() -> gameResource.addUsers(nullUsers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 리소스에 추가할 사용자가(이) 존재하지 않습니다.");
    }

    @DisplayName("게임 리소스에 사용자 추가 시, 이미 값이 존재하는 경우 에외를 발생시킨다.")
    @Test
    void addUsersTestByAlreadyExist() {
        //given
        Users usersA = ResourceGenerator.generateUsersWithCount(2);
        Users usersB = ResourceGenerator.generateUsersWithCount(2);
        gameResource.addUsers(usersA);

        //when, then
        assertThatThrownBy(() -> gameResource.addUsers(usersB))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 게임 리소스에 사용자가(이) 이미 존재하는 경우 변경할 수 없습니다.");
    }

    @DisplayName("게임 리소스에 사다리를 추가한다.")
    @Test
    void addLadderTest() {
        //given
        Ladder ladder = ResourceGenerator.generateLadderWithWidth(2);
        gameResource.addLadder(ladder);

        //when
        Ladder savedLadder = gameResource.getLadder();

        //then
        assertThat(savedLadder).isEqualTo(ladder);
    }

    @DisplayName("게임 리소스에 사다리 추가 시, 값이 null일 경우 에외를 발생시킨다.")
    @Test
    void addLadderTestByNull() {
        //given
        Ladder nullLadder = null;

        //when, then
        assertThatThrownBy(() -> gameResource.addLadder(nullLadder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 리소스에 추가할 사다리가(이) 존재하지 않습니다.");
    }

    @DisplayName("게임 리소스에 사다리 추가 시, 이미 값이 존재하는 경우 에외를 발생시킨다.")
    @Test
    void addLadderTestByAlreadyExist() {
        //given
        Ladder ladderA = ResourceGenerator.generateLadderWithWidth(2);
        Ladder ladderB = ResourceGenerator.generateLadderWithWidth(2);
        gameResource.addLadder(ladderA);

        //when, then
        assertThatThrownBy(() -> gameResource.addLadder(ladderB))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 게임 리소스에 사다리가(이) 이미 존재하는 경우 변경할 수 없습니다.");
    }

    @DisplayName("게임 리소스에 당첨품을 추가한다.")
    @Test
    void addPrizesTest() {
        //given
        Prizes prizes = ResourceGenerator.generatePrizesWithCount(2);
        gameResource.addPrizes(prizes);

        //when
        Prizes savedPrizes = gameResource.getPrizes();

        //then
        assertThat(savedPrizes).isEqualTo(prizes);
    }

    @DisplayName("게임 리소스에 당첨품 추가 시, 값이 null일 경우 에외를 발생시킨다.")
    @Test
    void addPrizesTestByNull() {
        //given
        Prizes nullPrizes = null;

        //when, then
        assertThatThrownBy(() -> gameResource.addPrizes(nullPrizes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 리소스에 추가할 당첨품가(이) 존재하지 않습니다.");
    }

    @DisplayName("게임 리소스에 당첨품 추가 시, 이미 값이 존재하는 경우 에외를 발생시킨다.")
    @Test
    void addPrizesTestByAlreadyExist() {
        //given
        Prizes prizesA = ResourceGenerator.generatePrizesWithCount(2);
        Prizes prizesB = ResourceGenerator.generatePrizesWithCount(2);
        gameResource.addPrizes(prizesA);

        //when, then
        assertThatThrownBy(() -> gameResource.addPrizes(prizesB))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 게임 리소스에 당첨품가(이) 이미 존재하는 경우 변경할 수 없습니다.");
    }
}
