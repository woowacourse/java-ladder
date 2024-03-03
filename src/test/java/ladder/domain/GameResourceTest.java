package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.domain.ladder.Ladder;
import ladder.domain.prize.Prizes;
import ladder.domain.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResourceTest {

    GameResource gameResource;

    @BeforeEach
    void beforeEach() {
        gameResource = new GameResource();
    }

    @DisplayName("게임 리소스를 추가한다.")
    @Test
    void add() {
        //given
        Users users = ResourceGenerator.generateUsers(2);
        Prizes prizes = ResourceGenerator.generatePrizes(2);
        Ladder ladder = ResourceGenerator.generateLadderWithHeightAndWidth(2, 2);

        gameResource.add(users, prizes, ladder);

        //when
        Users addedUsers = gameResource.getUsers();
        Prizes addedPrizes = gameResource.getPrizes();
        Ladder addedLadder = gameResource.getLadder();

        //then
        assertThat(addedUsers).isEqualTo(users);
        assertThat(addedPrizes).isEqualTo(prizes);
        assertThat(addedLadder).isEqualTo(ladder);
    }

    @DisplayName("게임 리소스 추가 시, 사용자가 null일 경우 에외를 발생시킨다.")
    @Test
    void addByNullUsers() {
        //given
        Users nullUsers = null;
        Prizes prizes = ResourceGenerator.generatePrizes(2);
        Ladder ladder = ResourceGenerator.generateLadderWithHeightAndWidth(2, 2);

        //when, then
        assertThatThrownBy(() -> gameResource.add(nullUsers, prizes, ladder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 리소스에 추가할 사용자가 존재하지 않습니다.");
    }

    @DisplayName("게임 리소스 추가 시, 당첨품이 null일 경우 에외를 발생시킨다.")
    @Test
    void addByNullPrizes() {
        //given
        Users users = ResourceGenerator.generateUsers(2);
        Prizes nullPrizes = null;
        Ladder ladder = ResourceGenerator.generateLadderWithHeightAndWidth(2, 2);

        //when, then
        assertThatThrownBy(() -> gameResource.add(users, nullPrizes, ladder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 리소스에 추가할 당첨품이 존재하지 않습니다.");
    }

    @DisplayName("게임 리소스 추가 시, 사다리가 null일 경우 에외를 발생시킨다.")
    @Test
    void addByNullLadder() {
        //given
        Users users = ResourceGenerator.generateUsers(2);
        Prizes prizes = ResourceGenerator.generatePrizes(2);
        Ladder nullLadder = null;

        //when, then
        assertThatThrownBy(() -> gameResource.add(users, prizes, nullLadder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 리소스에 추가할 사다리가 존재하지 않습니다.");
    }

    @DisplayName("게임 리소스 추가 시, 이미 값이 존재하는 경우 에외를 발생시킨다.")
    @Test
    void addByAlreadyExist() {
        //given
        Users users = ResourceGenerator.generateUsers(2);
        Prizes prizes = ResourceGenerator.generatePrizes(2);
        Ladder ladder = ResourceGenerator.generateLadderWithHeightAndWidth(2, 2);

        gameResource.add(users, prizes, ladder);

        //when, then
        assertThatThrownBy(() -> gameResource.add(users, prizes, ladder))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 게임 리소스가 이미 존재하는 경우 변경할 수 없습니다.");
    }

    @DisplayName("모든 리소스가 존재할 경우 True를 반환한다.")
    @Test
    void allFieldNotNull_true() {
        //given
        Users users = ResourceGenerator.generateUsers(2);
        Prizes prizes = ResourceGenerator.generatePrizes(2);
        Ladder ladder = ResourceGenerator.generateLadderWithHeightAndWidth(2, 2);

        gameResource.add(users, prizes, ladder);

        //when, then
        assertThat(gameResource.allFieldsNotNull()).isTrue();
    }

    @DisplayName("리소스가 없을 경우 False를 반환한다.")
    @Test
    void allFieldNotNull_false() {
        //given, when, then
        assertThat(gameResource.allFieldsNotNull()).isFalse();
    }

    @DisplayName("모든 리소스가 동일한 크기일 경우 True를 반환한다.")
    @Test
    void allFieldConsistentSize_true() {
        //given
        Users users = ResourceGenerator.generateUsers(10);
        Prizes prizes = ResourceGenerator.generatePrizes(10);
        Ladder ladder = ResourceGenerator.generateLadderWithHeightAndWidth(50, 10);

        gameResource.add(users, prizes, ladder);

        //when, then
        assertThat(gameResource.allFieldConsistentSize()).isTrue();
    }

    @DisplayName("리소스의 크기가 다를 경우 False를 반환한다.")
    @Test
    void allFieldConsistentSize_false() {
        //given
        Users users = ResourceGenerator.generateUsers(2);
        Prizes prizes = ResourceGenerator.generatePrizes(3);
        Ladder ladder = ResourceGenerator.generateLadderWithHeightAndWidth(2, 2);

        gameResource.add(users, prizes, ladder);

        //when, then
        assertThat(gameResource.allFieldConsistentSize()).isFalse();
    }
}
