package ladder.domain.prize;

import ladder.domain.user.User;
import ladder.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizesTest {

    @DisplayName("실행 결과의 수가 사용자 수와 같지 않다면 예외가 발생한다.")
    @Test
    void newUsersTestByCountUnderSize() {
        //given
        Prizes prizes = new Prizes(List.of(
                new Prize("에어팟"),
                new Prize("맥북"),
                new Prize("아이폰")
        ));

        Users users = new Users(List.of(
                new User("pobi"),
                new User("mason"),
                new User("ted"),
                new User("daon")
        ));

        int userSize = users.getNumberOfUsers();

        //when, then
        assertThatThrownBy(() -> prizes.isSameSize(userSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 실행 결과의 수가 사용자의 수와 동일하지 않습니다.");
    }
}
