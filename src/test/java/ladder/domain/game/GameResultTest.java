package ladder.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import ladder.domain.resource.prize.Prize;
import ladder.domain.resource.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    GameResult gameResult = new GameResult();

    @DisplayName("사용자의 사다리게임 결과를 저장한다.")
    @Test
    void save() {
        //given
        User user = new User("ted");
        Prize prize = new Prize("1000");

        //when
        gameResult.save(user, prize);
        Prize userResult = gameResult.getUserResult(user);

        //then
        assertThat(userResult).isEqualTo(prize);
    }

    @DisplayName("사용자의 사다리게임 결과 저장 시, 사용자가 없을 경우 예외를 발생시킨다.")
    @Test
    void saveByEmptyUser() {
        //given
        User user = null;
        Prize prize = new Prize("1000");

        //when, then
        assertThatThrownBy(() -> gameResult.save(user, prize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 저장하려는 사용자가 존재하지 않습니다.");
    }

    @DisplayName("사용자의 사다리게임 결과 저장 시, 당첨품이 없을 경우 예외를 발생시킨다.")
    @Test
    void saveByEmptyPrize() {
        //given
        User user = new User("ted");
        Prize prize = null;

        //when, then
        assertThatThrownBy(() -> gameResult.save(user, prize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 저장하려는 당첨품이 존재하지 않습니다.");
    }

    @DisplayName("사용자의 사다리게임 결과 저장 시, 게임의 결과로 이미 저장된 당첨품을 저장하는 경우 예외를 발생시킨다.")
    @Test
    void saveByAlreadyExistPrize() {
        //given
        User userA = new User("ted");
        User userB = new User("mason");

        Prize prizeA = new Prize("1000");

        //when
        gameResult.save(userA, prizeA);

        // then
        assertThatThrownBy(() -> gameResult.save(userB, prizeA))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당 당첨품은 다른 사용자의 결과로 저장되어 있습니다.");
    }

    @DisplayName("사용자의 결과 요청 시, 일치하는 사용자가 없을 경우 예외를 발생시킨다.")
    @Test
    void getUserResultByNoMatchUser() {
        //given
        User userA = new User("ted");
        User userB = new User("ted");
        Prize prize = new Prize("1000");

        //when
        gameResult.save(userA, prize);

        //then
        assertThatThrownBy(() -> gameResult.getUserResult(userB))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자의 결과를 조회할 수 없습니다.");
    }

    @DisplayName("저장된 모든 결과를 반환한다.")
    @Test
    void getAllResult() {
        //given
        User userA = new User("ted");
        User userB = new User("mason");

        Prize prizeA = new Prize("1000");
        Prize prizeB = new Prize("꽝");

        //when
        gameResult.save(userA, prizeA);
        gameResult.save(userB, prizeB);
        HashMap<User, Prize> result = gameResult.getAllResult();

        //then
        assertThat(result).hasSize(2);
        assertThat(result).containsEntry(userA, prizeA);
        assertThat(result).containsEntry(userB, prizeB);
    }
}
